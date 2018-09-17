package com.example.hossam.al_matger.FirstProductDetails.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hossam.al_matger.R;

import java.util.ArrayList;


/**
 * Created by hossam on 21/07/2018.
 */

public class TextAdapterForStorage extends RecyclerView.Adapter<TextAdapterForStorage.ViewHolder>  {

    private Context ctx;
    private int pos;
    private LayoutInflater inflater;
    private ImageView ivGallery;
    ArrayList<Uri> mArrayUri;
    public TextAdapterForStorage(Context ctx) {
        this.ctx = ctx;
        this.mArrayUri = mArrayUri;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_storage_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


     //
        // holder.ivGallery.setText(mValues.get(position).getName());
      //  holder.ivGallery.setImageURI(mArrayUri.get(position));
        if (position ==0)
            holder.ivtext.setText("16 جيجا بايت");
        else  if (position ==1)
            holder.ivtext.setText("32 جيجا بايت");
        else  if (position ==2)
            holder.ivtext.setText("64 جيجا بايت");

    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

      //  public BloodModel.GetData mItem;

        public TextView ivtext;
        public ViewHolder(View view) {

            super(view);
            mView = view;
            ivtext =  itemView.findViewById(R.id.textdesc);

        }
    }

}

