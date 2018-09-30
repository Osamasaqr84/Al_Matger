package com.example.hossam.al_matger.FirstStoreList.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hossam.al_matger.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Created by hossam on 21/07/2018.
 */

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder>  {

    private Context context;


    public StoreListAdapter(Context commentsActivity) {

        context=commentsActivity;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {




    }


    @Override
    public int getItemCount() {
        return 3;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public ViewHolder(View view) {

            super(view);
            mView = view;



        }
    }

}

