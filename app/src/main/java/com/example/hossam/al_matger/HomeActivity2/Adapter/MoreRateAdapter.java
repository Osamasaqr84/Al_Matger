package com.example.hossam.al_matger.HomeActivity2.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.HomeActivity2.ViewModel.MoreRateViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.MorerateBinding;

import java.util.ArrayList;

public class MoreRateAdapter extends RecyclerView.Adapter<MoreRateAdapter.CustomView> {


    private LayoutInflater layoutInflater;
    private ArrayList<MoreRateViewModel> arrayList;
    private Context context;


    public MoreRateAdapter(Context context , ArrayList<MoreRateViewModel> arrayList)
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

        MorerateBinding morerateBinding = DataBindingUtil.inflate(layoutInflater, R.layout.home2_more_rate_item,parent,false);
        return new CustomView(morerateBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        MoreRateViewModel categoryViewModel = arrayList.get(position);
     holder.bind(categoryViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        MorerateBinding cardBinding;

        public CustomView(MorerateBinding cardBinding) {
            super(cardBinding.getRoot());
            this.cardBinding = cardBinding;
        }


        public void bind(MoreRateViewModel departmentViewModel)
        {
            this.cardBinding.setMoreratemodel(departmentViewModel);
            cardBinding.executePendingBindings();
        }

        public MorerateBinding  getCardBinding()
        {
            return  cardBinding;
        }

    }

}
