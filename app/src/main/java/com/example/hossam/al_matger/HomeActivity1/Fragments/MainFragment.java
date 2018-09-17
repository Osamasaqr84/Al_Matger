package com.example.hossam.al_matger.HomeActivity1.Fragments;

import android.arch.lifecycle.Observer;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hossam.al_matger.HomeActivity1.Adapter.DepartmentAdapter;
import com.example.hossam.al_matger.HomeActivity1.Adapter.SliderPagerAdapter;
import com.example.hossam.al_matger.HomeActivity1.ViewModel.DepartmentViewModel;
import com.example.hossam.al_matger.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainFragment extends Fragment {
    @SerializedName("records")
    @Expose
    private RecyclerView recyclerView;
    private DepartmentViewModel departmentViewModel;
    private DepartmentAdapter customAdapter;
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
        View view = inflater.inflate(R.layout.fragment_main_home1, container, false);
        recyclerView = view.findViewById(R.id.recylerview);
        viewPager=view.findViewById(R.id.vp_slider);
        ll_dots = view.findViewById(R.id.ll_dots);
        departmentViewModel = new DepartmentViewModel();


        departmentViewModel.getData().observe(this, new Observer<ArrayList<DepartmentViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<DepartmentViewModel> arrayList) {

                customAdapter = new DepartmentAdapter(getActivity(),arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
                recyclerView.setAdapter(customAdapter);
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
