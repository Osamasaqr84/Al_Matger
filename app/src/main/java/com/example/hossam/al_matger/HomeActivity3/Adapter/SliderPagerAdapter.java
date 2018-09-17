package com.example.hossam.al_matger.HomeActivity3.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.hossam.al_matger.HomeActivity1.Model.SliderModel;
import com.example.hossam.al_matger.R;
import java.util.ArrayList;

/**
 * Created by hossam on 21/07/2018.
 */

public class SliderPagerAdapter extends PagerAdapter {
    private Context activity;
    Fragment fragment;
    FragmentManager fr;
    FragmentTransaction ft;

    public SliderPagerAdapter(FragmentActivity context) {
        activity=context;
      //  mValues=data;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.viewpagerslide_home3, container, false);
        ImageView im_slider =  view.findViewById(R.id.im_slider);
        TextView name= view.findViewById(R.id.doctornametxt);
        TextView views = new TextView(activity);
        views.setText("Item "+position);
        views.setGravity(Gravity.CENTER);
        views.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));

      /*  Glide.with(activity.getApplicationContext())
                .load("http://sfc-oman.com/library/sliderdoctor/15203505901920177050.jpg")
                .into(im_slider);*/
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
       return  6;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }


}

