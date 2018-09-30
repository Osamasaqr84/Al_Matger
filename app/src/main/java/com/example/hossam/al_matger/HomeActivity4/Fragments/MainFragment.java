package com.example.hossam.al_matger.HomeActivity4.Fragments;

import android.arch.lifecycle.Observer;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hossam.al_matger.HomeActivity4.Adapter.OffersAdapter;
import com.example.hossam.al_matger.HomeActivity4.Adapter.DepartmentAdapter;
import com.example.hossam.al_matger.HomeActivity4.Adapter.MoreRateAdapter;
import com.example.hossam.al_matger.HomeActivity4.Adapter.SliderPagerAdapter;
import com.example.hossam.al_matger.HomeActivity4.ViewModel.OffersViewModel;
import com.example.hossam.al_matger.HomeActivity4.ViewModel.DepartmentViewModel;
import com.example.hossam.al_matger.HomeActivity4.ViewModel.MoreRateViewModel;
import com.example.hossam.al_matger.R;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainFragment extends Fragment {

    @SerializedName("records")
    @Expose
    private RecyclerView departrecyclerView,moreraterecyclerView,categryrecyclerView;
    private DepartmentViewModel departmentViewModel;
    private MoreRateViewModel moreRateViewModel;
    private OffersViewModel offersViewModel;
    private DepartmentAdapter departmentAdapter;
    private MoreRateAdapter moreRateAdapter;
    private OffersAdapter offersAdapter;
    private LinearLayout ll_dots;
    ViewPager viewPager;
    private SliderPagerAdapter sliderPagerAdapter;
    private TextView[] dots;
    int page_position = 0,arraysize=0;

    public MainFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_home4, container, false);
        departrecyclerView = view.findViewById(R.id.depatrecylerview);
        moreraterecyclerView = view.findViewById(R.id.morraterecylerview);
        categryrecyclerView = view.findViewById(R.id.categryrecylerview);
        viewPager=view.findViewById(R.id.vp_slider);
        ll_dots = view.findViewById(R.id.ll_dots);

        departmentViewModel = new DepartmentViewModel();
        moreRateViewModel = new MoreRateViewModel();
        offersViewModel = new OffersViewModel();

        departmentViewModel.getData().observe(this, new Observer<ArrayList<DepartmentViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<DepartmentViewModel> arrayList) {
                departmentAdapter = new DepartmentAdapter(getActivity(),arrayList);
                ///departrecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                departrecyclerView.setAdapter(departmentAdapter);
            }
        });

        moreRateViewModel.getData().observe(this, new Observer<ArrayList<MoreRateViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MoreRateViewModel> arrayList) {
                moreRateAdapter = new MoreRateAdapter(getActivity(),arrayList);
             //   moreraterecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                moreraterecyclerView.setAdapter(moreRateAdapter);
            }
        });

        offersViewModel.getData().observe(this, new Observer<ArrayList<OffersViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<OffersViewModel> arrayList) {

                offersAdapter = new OffersAdapter(getActivity(),arrayList);
                //   moreraterecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
               categryrecyclerView.setAdapter(offersAdapter);
            }
        });


        init();
        //  viewPager.setPageTransformer(false,new ZoomOutPageTransformer());
        addBottomDots(0);
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == arraysize) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                viewPager.setCurrentItem(page_position, true);

            }
        };

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 6000, 4000);

        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            private static final float MIN_SCALE = 0.85f;
            private static final float MIN_ALPHA = 0.5f;
            @Override
            public void transformPage(View view, float position) {

                view.setTranslationX(-position * view.getWidth());
                if (Math.abs(position) < 0.5) {
                    view.setVisibility(View.VISIBLE);
                    view.setScaleX(1 - Math.abs(position));
                    view.setScaleY(1 - Math.abs(position));
                } else if (Math.abs(position) > 0.5) {
                    view.setVisibility(View.GONE);
                }
            }
        });

        return view;
    }

    private void init() {
        getSlidersData();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
               public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void getSlidersData() {
        arraysize=6;

        sliderPagerAdapter = new SliderPagerAdapter(getActivity());
        viewPager.setAdapter(sliderPagerAdapter);
    }
    private void addBottomDots(int currentPage) {

        dots = new TextView[arraysize];
        ll_dots.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            if (getContext()!=null) {
                dots[i] = new TextView(getContext());
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);
                if (i==currentPage)
                    dots[i].setTextColor(Color.parseColor("#FFFFFF"));
                else
                    dots[i].setTextColor(Color.parseColor("#000000"));
                ll_dots.addView(dots[i]);
            }
        }

        //if (dots!=null&&dots.length>0 && currentPage>=0&&currentPage<dots.length)
        //  dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }

}
