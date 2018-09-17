package com.example.hossam.al_matger.HomeActivity4.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.HomeActivity4.ViewModel.OffersViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.OfferDataPinding4;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.CustomView> {




    private LayoutInflater layoutInflater;
    private ArrayList<OffersViewModel> arrayList;
    private Context context;

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    public OffersAdapter(Context context , ArrayList<OffersViewModel> arrayList)
    {
        this.arrayList = arrayList;
        this.context =  context;
    }


    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(layoutInflater == null)
        {
            layoutInflater = LayoutInflater.from(parent.getContext());

        }

        OfferDataPinding4  categryPinding = DataBindingUtil.inflate(layoutInflater, R.layout.home4_offers_item,parent,false);
        return new CustomView(categryPinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

//        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
//        layoutParams.setFullSpan(true);
//
     OffersViewModel categoryViewModel = arrayList.get(position);
     holder.bind(categoryViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class CustomView extends RecyclerView.ViewHolder {

        OfferDataPinding4 categryPinding;

        public CustomView(OfferDataPinding4 cardBinding) {
            super(cardBinding.getRoot());
            this.categryPinding = cardBinding;
        }


        public void bind(OffersViewModel categryViewModel)
        {
            this.categryPinding.setOffersmodel(categryViewModel);
            categryPinding.executePendingBindings();
        }

        public OfferDataPinding4  getCardBinding()
        {
            return  categryPinding;
        }

    }


}
