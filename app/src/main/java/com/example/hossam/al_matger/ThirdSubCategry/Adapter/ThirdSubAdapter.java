package com.example.hossam.al_matger.ThirdSubCategry.Adapter;

import android.content.Context;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hossam.al_matger.R;


public class ThirdSubAdapter extends RecyclerView.Adapter<ThirdSubAdapter.ViewHolder> {

    Context mcontext;
    SliderPagerAdapter sliderPagerAdapter;
    public ThirdSubAdapter(FragmentActivity activity) {
        mcontext=activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.third_subcategry_adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        sliderPagerAdapter = new SliderPagerAdapter(mcontext);
       holder.viewPager.setAdapter(sliderPagerAdapter);
       holder.prev.setOnClickListener(new View.OnClickListener() {
           @Override

           public void onClick(View v) {

               holder.viewPager.setCurrentItem(holder.viewPager.getCurrentItem() - 1);
           }
       });

        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.viewPager.setCurrentItem(holder.viewPager.getCurrentItem() + 1);
            }
        });
       //holder.title.setText(mValues.get(position).getSubject());

    }

    @Override
    public int getItemCount() {
      return  10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public ViewPager viewPager;
        ImageView prev,next;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            viewPager =  view.findViewById(R.id.viewpager);
            prev = view.findViewById(R.id.prev);
            next = view.findViewById(R.id.next);
        }

    }
}
