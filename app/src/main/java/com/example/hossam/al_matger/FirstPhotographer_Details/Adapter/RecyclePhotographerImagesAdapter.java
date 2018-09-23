package com.example.hossam.al_matger.FirstPhotographer_Details.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hossam.al_matger.FirstPhotographer_Details.Activities.DetailImageActivity;
import com.example.hossam.al_matger.R;


/**
 * Created by hossam on 21/07/2018.
 */

public class RecyclePhotographerImagesAdapter extends RecyclerView.Adapter<RecyclePhotographerImagesAdapter.ViewHolder>  {

    private Context context;
    public RecyclePhotographerImagesAdapter(Context c) {
        context=c;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_inphotographer_details, parent, false);
        return new ViewHolder(view);
    }
    //http://sfc-oman.com/library/exp/
//http://192.168.1.8:8080/sfc/library/sfc/
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(context, DetailImageActivity.class);
//                //intent.putParcelableArrayListExtra("data", images);
//                intent.putExtra("pos",position);
              context.startActivity(intent);
            }
        });


      /*holder.doctorname.setText(mValues.get(position).getName());
      Glide.with(context).load("http://sfc-oman.com/library/doctors/" +
                mValues.get(position).getPhoto()).into(holder.doctorImage);*/
    }

    @Override
    public int getItemCount() {
        return 6;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

      //  public BloodModel.GetData mItem;
        public TextView doctorname;
        public ImageView Image;
        public ViewHolder(View view) {

            super(view);
            mView = view;
         //doctorname=mView.findViewById(R.id.doctorname);
           Image=mView.findViewById(R.id.image);

        }
    }

}

