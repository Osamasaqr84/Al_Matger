package com.example.hossam.al_matger.ThirdSubCategry.Fragments;

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
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.ThirdSubCategry.Adapter.ThirdSubAdapter;



public class MainFragment extends Fragment {



    private RecyclerView recyclerView;
    private ThirdSubAdapter thirdSubCatAdapter;

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

        View view = inflater.inflate(R.layout.fragment_main_subcategry3, container, false);
        recyclerView = view.findViewById(R.id.recylerview);
        thirdSubCatAdapter = new ThirdSubAdapter(getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        recyclerView.setAdapter(thirdSubCatAdapter);

        return view;
    }
}
