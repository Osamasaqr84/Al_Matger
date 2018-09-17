package com.example.hossam.al_matger.HomeActivity2.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.HomeActivity2.ViewModel.CaegrytViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.CategryPinding;

import java.util.ArrayList;

public class CategryAdapter extends RecyclerView.Adapter<CategryAdapter.CustomView> {




    private LayoutInflater layoutInflater;
    private ArrayList<CaegrytViewModel> arrayList;
    private Context context;

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    public CategryAdapter(Context context , ArrayList<CaegrytViewModel> arrayList)
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

        CategryPinding  categryPinding = DataBindingUtil.inflate(layoutInflater, R.layout.home2_category_item,parent,false);
        return new CustomView(categryPinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

//        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
//        layoutParams.setFullSpan(true);
//
     CaegrytViewModel categoryViewModel = arrayList.get(position);
     holder.bind(categoryViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class CustomView extends RecyclerView.ViewHolder {

        CategryPinding categryPinding;

        public CustomView(CategryPinding cardBinding) {
            super(cardBinding.getRoot());
            this.categryPinding = cardBinding;
        }


        public void bind(CaegrytViewModel categryViewModel)
        {
            this.categryPinding.setCategrymodel(categryViewModel);
            categryPinding.executePendingBindings();
        }

        public CategryPinding  getCardBinding()
        {
            return  categryPinding;
        }

    }


}
