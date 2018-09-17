package com.example.hossam.al_matger.FirstProductDetails.Fragments;

import android.arch.lifecycle.Observer;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hossam.al_matger.FirstProductDetails.Adapter.ImagesAdapterForColor;
import com.example.hossam.al_matger.FirstProductDetails.Adapter.ImagesAdapterForSideImages;
import com.example.hossam.al_matger.FirstProductDetails.Adapter.SliderPagerAdapter;
import com.example.hossam.al_matger.FirstProductDetails.Adapter.TextAdapterForStorage;
import com.example.hossam.al_matger.FirstResturantList.Adapter.ResturantListAdapter;
import com.example.hossam.al_matger.FirstResturantList.ViewModel.Resturant_list_ItemViewModel;
import com.example.hossam.al_matger.Helper.BroadcastHelper;
import com.example.hossam.al_matger.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    @SerializedName("records")
    @Expose
    ///////////////definition of all recycles
    private RecyclerView recyclerViewforsideimages,recyclerViewforstorage,recyclerViewforitemcolors;

    private Resturant_list_ItemViewModel resturant_list_itemViewModel;

    ///////////////definition of all adapters
    ImagesAdapterForColor imagesAdapterForColor;
    ImagesAdapterForSideImages imagesAdapterForSideImages;
    SliderPagerAdapter sliderPagerAdapter;
    TextAdapterForStorage textAdapterForStorage;
    ImageView showmore;
    LinearLayoutManager layoutManager;
    ///////////definition of viewpager and next,prev buttons
    public ViewPager viewPager;
    ImageView prev,next;

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
        View view = inflater.inflate(R.layout.fragment_first_product_details, container, false);

        /////////////inflate  all recycleviews and viewpager
        recyclerViewforsideimages = view.findViewById(R.id.recylerviewimages);
        recyclerViewforitemcolors = view.findViewById(R.id.recylerviewcolors);
        recyclerViewforstorage = view.findViewById(R.id.recylerviewstorage);
        viewPager =view.findViewById(R.id.viewpager);
        prev =view.findViewById(R.id.prev);
        next =view.findViewById(R.id.next);
        showmore =view.findViewById(R.id.showmore);
        /////////end

        /////////////initialize the adapters
        sliderPagerAdapter = new SliderPagerAdapter(getActivity()); //////for initialize
        imagesAdapterForColor =new ImagesAdapterForColor(getActivity()); ////item colorsadapter
        imagesAdapterForSideImages =new ImagesAdapterForSideImages(getActivity()); //sideimage adapter
        textAdapterForStorage =new TextAdapterForStorage(getActivity()); /////storage adapter
            ////////end

        layoutManager =new LinearLayoutManager(getActivity());
        recyclerViewforsideimages.setLayoutManager(layoutManager);

        ////////////////set adapters for recycles
        viewPager.setAdapter(sliderPagerAdapter);
        recyclerViewforsideimages.setAdapter(imagesAdapterForSideImages);
        recyclerViewforitemcolors.setAdapter(imagesAdapterForColor);
        recyclerViewforstorage.setAdapter(textAdapterForStorage);

        ////////prev,next actions  for viewpager
       prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

       next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        /////end

        resturant_list_itemViewModel = new Resturant_list_ItemViewModel();
        resturant_list_itemViewModel.getData().observe(this, new Observer<ArrayList<Resturant_list_ItemViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Resturant_list_ItemViewModel> arrayList) {

            }
        });
        ///////show more action
        showmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalItemCount = recyclerViewforsideimages.getAdapter().getItemCount();
                if (totalItemCount <= 0) return;
                int lastVisibleItemIndex = layoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemIndex >= totalItemCount) return;
                layoutManager.smoothScrollToPosition(recyclerViewforsideimages,null,lastVisibleItemIndex+1);
            }
        });
        return view;
    }


    Receiver receiver;
    boolean isReciverRegistered = false;
    @Override
    public void onResume() {
        super.onResume();

        if (receiver == null) {
            receiver = new Receiver();
            IntentFilter filter = new IntentFilter(BroadcastHelper.ACTION_NAME);
            getActivity().registerReceiver(receiver, filter);
            isReciverRegistered = true;
        }


    }

    @Override
    public void onDestroy() {
        if (isReciverRegistered) {
            if (receiver != null)
                getActivity().unregisterReceiver(receiver);
        }
        super.onDestroy();

    }


    private class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            Log.v("r", "receive " + arg1.getStringExtra(BroadcastHelper.BROADCAST_EXTRA_METHOD_NAME));
            String methodName = arg1.getStringExtra(BroadcastHelper.BROADCAST_EXTRA_METHOD_NAME);
            if (methodName != null && methodName.length() > 0) {
                Log.v("receive", methodName);
                switch (methodName) {
                    case "image_position":
                     int   position = arg1.getIntExtra("position",0);
                     viewPager.setCurrentItem(position);
                        break;

                    default:
                        break;
                }
            }
        }
    }
}
