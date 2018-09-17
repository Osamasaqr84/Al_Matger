package com.example.hossam.al_matger.FirstAddProductPackage.Adapter;

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

public class ImagesAdapterForProduct extends RecyclerView.Adapter<ImagesAdapterForProduct.ViewHolder>  {

    private Context ctx;
    private int pos;
    private LayoutInflater inflater;
    private ImageView ivGallery;
    ArrayList<Uri> mArrayUri;
    public ImagesAdapterForProduct(Context ctx, ArrayList<Uri> mArrayUri) {
        this.ctx = ctx;
        this.mArrayUri = mArrayUri;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_image_add_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.ivGallery.setImageURI(mArrayUri.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayUri.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public ImageView ivGallery;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivGallery =  itemView.findViewById(R.id.ivGallery);
        }
    }

}

