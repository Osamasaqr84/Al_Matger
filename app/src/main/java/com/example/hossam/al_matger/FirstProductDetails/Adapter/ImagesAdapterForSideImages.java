package com.example.hossam.al_matger.FirstProductDetails.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hossam.al_matger.Helper.BroadcastHelper;
import com.example.hossam.al_matger.R;

import java.util.ArrayList;


/**
 * Created by hossam on 21/07/2018.
 */

public class ImagesAdapterForSideImages extends RecyclerView.Adapter<ImagesAdapterForSideImages.ViewHolder>  {

    private Context ctx;
    private int pos;
    private LayoutInflater inflater;
    private ImageView ivGallery;
    ArrayList<Uri> mArrayUri;
    public ImagesAdapterForSideImages(Context ctx) {
        this.ctx = ctx;
        this.mArrayUri = mArrayUri;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_image_side_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


     //
        // holder.ivGallery.setText(mValues.get(position).getName());
      //  holder.ivGallery.setImageURI(mArrayUri.get(position));
        if (position ==0)
            holder.ivGallery.setImageResource(R.drawable.mobile);
        else  if (position ==1)
            holder.ivGallery.setImageResource(R.drawable.mobile2);
        else  if (position ==2)
            holder.ivGallery.setImageResource(R.drawable.mobile2);

        holder.ivGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("image_position");
                intent.putExtra("position",position);
                BroadcastHelper.sendInform(ctx, "image_position", intent);
            }
        });
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

