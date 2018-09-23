package com.example.hossam.al_matger.FirstMyChats.Fragments;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hossam.al_matger.FirstMyOrders.Adapter.FirstMyOrderAdapter;
import com.example.hossam.al_matger.FirstMyOrders.ViewModel.MyOrders_ItemViewModel;
import com.example.hossam.al_matger.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MainFragment extends Fragment {
    @SerializedName("records")
    @Expose
    private RecyclerView recyclerView;
    private MyOrders_ItemViewModel myOrders_itemViewModel;
    private FirstMyOrderAdapter firstMyOrdersActivity;

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
        View view = inflater.inflate(R.layout.fragment_main_myorders, container, false);
        recyclerView = view.findViewById(R.id.recylerview);

        myOrders_itemViewModel = new MyOrders_ItemViewModel();
        myOrders_itemViewModel.getData().observe(this, new Observer<ArrayList<MyOrders_ItemViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MyOrders_ItemViewModel> arrayList) {
                firstMyOrdersActivity = new FirstMyOrderAdapter(getActivity(),arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
                recyclerView.setAdapter(firstMyOrdersActivity);
            }
        });

        return view;
    }
}
