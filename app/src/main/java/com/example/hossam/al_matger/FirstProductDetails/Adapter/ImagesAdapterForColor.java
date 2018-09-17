package com.example.hossam.al_matger.FirstProductDetails.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.hossam.al_matger.R;

import java.util.ArrayList;


/**
 * Created by hossam on 21/07/2018.
 */

public class ImagesAdapterForColor extends RecyclerView.Adapter<ImagesAdapterForColor.ViewHolder>  {

    private Context ctx;
    private int pos;
    private LayoutInflater inflater;
    private ImageView ivGallery;
    ArrayList<Uri> mArrayUri;
    public ImagesAdapterForColor(Context ctx) {
        this.ctx = ctx;
        this.mArrayUri = mArrayUri;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_color_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


     //
        // holder.ivGallery.setText(mValues.get(position).getName());
      //  holder.ivGallery.setImageURI(mArrayUri.get(position));
        if (position ==0)
            holder.ivGallery.setImageResource(R.drawable.color);
        else  if (position ==1)
            holder.ivGallery.setImageResource(R.drawable.color2);
        else  if (position ==2)
            holder.ivGallery.setImageResource(R.drawable.color3);
        else  if (position ==3)
            holder.ivGallery.setImageResource(R.drawable.color4);
    }

    @Override
    public int getItemCount() {
        return 7;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

      //  public BloodModel.GetData mItem;

        public ImageView ivGallery;
        public ViewHolder(View view) {

            super(view);
            mView = view;
            ivGallery = (ImageView) itemView.findViewById(R.id.ivGallery);

        }
    }

}

