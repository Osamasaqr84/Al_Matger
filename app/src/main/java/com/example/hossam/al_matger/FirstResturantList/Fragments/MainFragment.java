package com.example.hossam.al_matger.FirstResturantList.Fragments;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
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

import com.example.hossam.al_matger.FirstResturantList.Adapter.ResturantListAdapter;
import com.example.hossam.al_matger.FirstResturantList.ViewModel.Resturant_list_ItemViewModel;
import com.example.hossam.al_matger.SecondSubCategry.Adapter.SecondSubCatAdapter;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.SecondSubCategry.ViewModel.SubCat_ItemViewModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MainFragment extends Fragment {
    @SerializedName("records")
    @Expose
    private RecyclerView recyclerView;
    private Resturant_list_ItemViewModel resturant_list_itemViewModel;
    private ResturantListAdapter firstSubCatAdapter;
    private LinearLayout ll_dots;
    ViewPager viewPager;
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
        View view = inflater.inflate(R.layout.fragment_first_resturant_list, container, false);
        recyclerView = view.findViewById(R.id.recylerview);

        resturant_list_itemViewModel = new Resturant_list_ItemViewModel();

        resturant_list_itemViewModel.getData().observe(this, new Observer<ArrayList<Resturant_list_ItemViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Resturant_list_ItemViewModel> arrayList) {
                firstSubCatAdapter = new ResturantListAdapter(getActivity(),arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
                recyclerView.setAdapter(firstSubCatAdapter);
            }
        });

        return view;
    }
}
