package com.example.hossam.al_matger.HomeActivity3.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hossam.al_matger.R;

/**
 * Created by mohammedsa on 25/02/2018.
 */

public class Slidre4_home_adapter extends PagerAdapter {

    private LayoutInflater inflater;
    private Context context;
    String link;

    public Slidre4_home_adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.image_slider_home, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image_slider);


        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }



}

