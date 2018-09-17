package com.example.hossam.al_matger.FirstAddProductPackage.Adapter;

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

public class ProductAdapterForSizes extends RecyclerView.Adapter<ProductAdapterForSizes.ViewHolder>  {

    private Context ctx;
    ArrayList<String> storages;
    public ProductAdapterForSizes(Context ctx,  ArrayList<String> storages2) {
        this.ctx = ctx;
        this.storages = storages2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_storage_item_add_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.ivtext.setText(storages.get(position));
    holder.cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            storages.remove(storages.get(position));
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, storages.size());
        }
    });

    }

    @Override
    public int getItemCount() {
        return storages.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

      //  public BloodModel.GetData mItem;
        public TextView ivtext;
        ImageView  cancel;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivtext =  itemView.findViewById(R.id.textdesc);
            cancel =  itemView.findViewById(R.id.cancel);

        }
    }

}

