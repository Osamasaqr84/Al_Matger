package com.example.hossam.al_matger.HomeActivity4.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hossam.al_matger.R;

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
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.viewpagerslide_home1, container, false);
        ImageView im_slider =  view.findViewById(R.id.im_slider);
        TextView name= view.findViewById(R.id.doctornametxt);

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

