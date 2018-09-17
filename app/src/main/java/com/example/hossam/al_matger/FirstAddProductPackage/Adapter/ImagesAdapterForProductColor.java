package com.example.hossam.al_matger.FirstAddProductPackage.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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

public class ImagesAdapterForProductColor extends RecyclerView.Adapter<ImagesAdapterForProductColor.ViewHolder>  {

    private Context ctx;
    private int pos;

    ArrayList<Integer> mArrayUri;
    public ImagesAdapterForProductColor(Context ctx, ArrayList<Integer> mArrayUri1) {
        this.ctx = ctx;
        this.mArrayUri = mArrayUri1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_color_product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

       // holder.ivGallery.setBackgroundColor(mArrayUri.get(position));
        GradientDrawable drawable = (GradientDrawable)holder.ivGallery.getBackground();
        drawable.setColor(mArrayUri.get(position));

        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArrayUri.remove(mArrayUri.get(position));
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mArrayUri.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayUri.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
      //  public BloodModel.GetData mItem;
        public TextView ivGallery;
        public ImageView cancel;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivGallery =  itemView.findViewById(R.id.ivGallery);
            cancel =  itemView.findViewById(R.id.cancel);
        }
    }

}

