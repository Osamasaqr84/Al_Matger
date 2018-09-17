package com.example.hossam.al_matger.HomeActivity3.Fragments;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.hossam.al_matger.HomeActivity3.Adapter.DepartmentAdapter;
import com.example.hossam.al_matger.HomeActivity3.Adapter.SliderPagerAdapter;
import com.example.hossam.al_matger.HomeActivity3.Adapter.Slidre4_home_adapter;
import com.example.hossam.al_matger.HomeActivity3.ViewModel.DepartmentViewModel;
import com.example.hossam.al_matger.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.viewpagerindicator.CirclePageIndicator;
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
    String str_device;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    CirclePageIndicator indicator;
    Slidre4_home_adapter viewadapter;

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
        View view = inflater.inflate(R.layout.fragment_main_home3, container, false);
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

        viewadapter=new Slidre4_home_adapter(getActivity());
        viewPager.setAdapter(viewadapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(120, 0, 120, 0);
        viewPager.setPageMargin(40);
        indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        init();

        return view;
    }

    private void init() {



        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(4 * density);

        NUM_PAGES =10;

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 4000);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

}
