package com.example.hossam.al_matger.FirstAddProductPackage.Activities;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hossam.al_matger.FirstAddProductPackage.Adapter.ImagesAdapterForProduct;
import com.example.hossam.al_matger.FirstAddProductPackage.Adapter.ImagesAdapterForProductColor;
import com.example.hossam.al_matger.FirstAddProductPackage.Adapter.ProductAdapterForSizes;
import com.example.hossam.al_matger.R;
import com.github.irshulx.Editor;
import com.github.irshulx.EditorListener;
import com.github.irshulx.models.EditorTextStyle;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstAddProductActivity extends AppCompatActivity implements ColorPickerDialogListener {

    int PICK_IMAGE_MULTIPLE = 1;
    private ImagesAdapterForProduct galleryAdapter;
    RecyclerView recyclerViewGallery,recyclerViewcolors,recycleviewStorage;
    ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
    ArrayList<Integer> colorsCodes = new ArrayList<Integer>();
    ArrayList<String> stores = new ArrayList<String>();
    String imageEncoded;
    Editor editor;
    ImagesAdapterForProductColor imagesAdapterForProductColor;
    ProductAdapterForSizes productAdapterForSizes;
    LinearLayout linearLayoutsizes,linearLayoutcolores;
    private int mYear;
    private int mMonth;
    private int mDay;
    private String date_time = "", day_name, month_name, days_number;
    EditText dateofdscount;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.addproduct);
        ///////////initialize items
        recyclerViewGallery = findViewById(R.id.images_recycler);
        recyclerViewcolors = findViewById(R.id.colors_recycler);
        recycleviewStorage = findViewById(R.id.sizes_recycler);
        editor = findViewById(R.id.editor);
        linearLayoutsizes =findViewById(R.id.productsizes);
        linearLayoutcolores =findViewById(R.id.productcolors);
        dateofdscount =findViewById(R.id.dateofdscount);
            ///////setup recycles with adapters
        productAdapterForSizes=new ProductAdapterForSizes(FirstAddProductActivity.this,stores);
        recycleviewStorage.setAdapter(productAdapterForSizes);
        imagesAdapterForProductColor=new ImagesAdapterForProductColor(FirstAddProductActivity.this,colorsCodes);
        recyclerViewcolors.setAdapter(imagesAdapterForProductColor);
        setUpEditor();

        dateofdscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
      //  setGhost((Button) findViewById(R.id.btnRender));
    }


    public void getImages(View view) {

        int permissionCheck = ContextCompat.checkSelfPermission(FirstAddProductActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            permission();
        }

        else {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);
        }
    }

    public void permission() {
        final Dialog dialog = new Dialog(FirstAddProductActivity.this, R.style.AppCompatAlertDialogStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_permission_cam);
        dialog.show();
        Button cancel_log, open;
        ImageView close_dialog;
        open =  dialog.findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                final Intent i = new Intent();
                i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.setData(Uri.parse("package:" + FirstAddProductActivity.this.getPackageName()));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                FirstAddProductActivity.this.startActivity(i);
            }
        });

        cancel_log = dialog.findViewById(R.id.cancel_log);
        cancel_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        close_dialog = dialog.findViewById(R.id.close_dialog);
        close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            // When an Image is picked
            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK
                    && null != data) {
                mArrayUri.clear();
                // Get the Image from data
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                if(data.getData()!=null){
                    Uri mImageUri=data.getData();
                    // Get the cursor
                    Cursor cursor = getContentResolver().query(mImageUri,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imageEncoded  = cursor.getString(columnIndex);
                    cursor.close();
                    ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
                    mArrayUri.add(mImageUri);
                    galleryAdapter = new ImagesAdapterForProduct(getApplicationContext(),mArrayUri);
                    recyclerViewGallery.setAdapter(galleryAdapter);
               //encode
                    /*if (mArrayUri.size() > 0) {
                        for (int i = 0; i < mArrayUri.size(); i++) {
                            parts.add(prepareFilePart("image" + "[" + i + "]", mArrayUri.get(i)));
                            Log.i("[5]", "[" + i + "]");
                        }
                    } */

                } else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        for (int i = 0; i < mClipData.getItemCount(); i++) {
                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            mArrayUri.add(uri);
                            // Get the cursor
                            Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
                            // Move to first row
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            imageEncoded  = cursor.getString(columnIndex);
                           // imagesEncodedList.add(imageEncoded);
                            cursor.close();
                            galleryAdapter = new ImagesAdapterForProduct(getApplicationContext(),mArrayUri);
                            recyclerViewGallery.setAdapter(galleryAdapter);

                        }
                        Log.v("LOG_TAG", "Selected Images" + mArrayUri.size());
                    }

                 /*   if (mArrayUri.size() > 0) {
                        for (int i = 0; i < mArrayUri.size(); i++) {
                            parts.add(prepareFilePart("image" + "[" + i + "]", mArrayUri.get(i)));
                        }
                    }*/
                }
            } else {
                Toast.makeText(this, getResources().getString(R.string.notselect),
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, getResources().getString(R.string.error), Toast.LENGTH_LONG)
                    .show();
            Log.v("exc",e.getMessage());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void addcolor(View view) {
        ColorPickerDialog.newBuilder().show(FirstAddProductActivity.this);
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        colorsCodes.add(color);
       imagesAdapterForProductColor.notifyDataSetChanged();
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }

    public void addstorage(View view) {
        openDialogForAddStorage();
    }

    private void setUpEditor() {


        findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.BOLD);
            }
        });

        findViewById(R.id.action_indent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.INDENT);
            }
        });

        findViewById(R.id.action_outdent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.OUTDENT);
            }
        });

        findViewById(R.id.action_bulleted).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertList(false);
            }
        });

        findViewById(R.id.action_unordered_numbered).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertList(true);
            }
        });

        findViewById(R.id.action_hr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertDivider();
            }
        });


        findViewById(R.id.action_erase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clearAllContents();
            }
        });

        //editor.dividerBackground=R.drawable.divider_background_dark;
        //editor.setFontFace(R.string.fontFamily__serif);

        Map<Integer, String> headingTypeface = getHeadingTypeface();
        Map<Integer, String> contentTypeface = getContentface();
        editor.setHeadingTypeface(headingTypeface);
        editor.setContentTypeface(contentTypeface);
        editor.setDividerLayout(R.layout.tmpl_divider_layout);
        editor.setEditorImageLayout(R.layout.tmpl_image_view);
        editor.setListItemLayout(R.layout.tmpl_list_item);
        //editor.StartEditor();
        editor.setEditorListener(new EditorListener() {
            @Override
            public void onTextChanged(EditText editText, Editable text) {
                // Toast.makeText(EditorTestActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUpload(Bitmap image, String uuid) {

            }
        });
        editor.render();
    }


    public Map<Integer, String> getHeadingTypeface() {
        Map<Integer, String> typefaceMap = new HashMap<>();
        typefaceMap.put(Typeface.NORMAL, "fonts/GreycliffCF-Bold.ttf");
        typefaceMap.put(Typeface.BOLD, "fonts/GreycliffCF-Heavy.ttf");
        typefaceMap.put(Typeface.ITALIC, "fonts/GreycliffCF-Heavy.ttf");
        typefaceMap.put(Typeface.BOLD_ITALIC, "fonts/GreycliffCF-Bold.ttf");
        return typefaceMap;
    }

    public Map<Integer, String> getContentface() {
        Map<Integer, String> typefaceMap = new HashMap<>();
        typefaceMap.put(Typeface.NORMAL, "fonts/Lato-Medium.ttf");
        typefaceMap.put(Typeface.BOLD, "fonts/Lato-Bold.ttf");
        typefaceMap.put(Typeface.ITALIC, "fonts/Lato-MediumItalic.ttf");
        typefaceMap.put(Typeface.BOLD_ITALIC, "fonts/Lato-BoldItalic.ttf");
        return typefaceMap;
    }


    private void openDialogForAddStorage(){

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout. alert_add_item_sizes, null);
        dialogBuilder.setView(dialogView);
        final EditText storagetxt =  dialogView.findViewById(R.id.dialogEditText);
        TextView save;
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.show();
        save =dialogView.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (storagetxt.getText().toString().matches(""))
                    storagetxt.setError(getResources().getString(R.string.complet));
                else {
                    stores.add(storagetxt.getText().toString());
                    productAdapterForSizes.notifyDataSetChanged();
                    alertDialog.dismiss();
                }
            }
        });
    }



    public void showcolorlayout(View view) {
        linearLayoutcolores.setVisibility(View.VISIBLE);
    }

    public void showsizeslayout(View view) {

        linearLayoutsizes.setVisibility(View.VISIBLE);
    }


    private void datePicker() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(FirstAddProductActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Log.d("year",year+"");
                        Log.d("monthOfYear",monthOfYear+"");
                        Log.d("dayOfMonth",dayOfMonth+"");
                        dateofdscount.setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}

