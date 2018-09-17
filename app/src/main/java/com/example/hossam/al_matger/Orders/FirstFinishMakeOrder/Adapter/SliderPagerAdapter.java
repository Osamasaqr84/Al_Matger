package com.example.hossam.al_matger.Orders.FirstFinishMakeOrder.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hossam.al_matger.R;

/**
 * Created by hossam on 21/07/2018.
 */

public class SliderPagerAdapter extends PagerAdapter {
    private Context activity;


    public SliderPagerAdapter(Context context) {
        activity=context;
      //  mValues=data;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.third_subcategry_for_viewpager, container, false);

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
       return  4;
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

