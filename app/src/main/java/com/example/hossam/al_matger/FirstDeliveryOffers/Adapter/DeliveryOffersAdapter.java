package com.example.hossam.al_matger.FirstDeliveryOffers.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.FirstDeliveryOffers.ViewModel.DeliveryOffersViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.DeliveryOrdersBinding;

import java.util.ArrayList;

public class DeliveryOffersAdapter extends RecyclerView.Adapter<DeliveryOffersAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<DeliveryOffersViewModel> arrayList;
    private Context context;


    public DeliveryOffersAdapter(Context context , ArrayList<DeliveryOffersViewModel> arrayList)
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

        DeliveryOrdersBinding  deliveryOrdersBinding = DataBindingUtil.inflate(layoutInflater, R.layout.first_deliveryoffers_adapter_item,parent,false);
        return new CustomView(deliveryOrdersBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        DeliveryOffersViewModel deliveryOffersViewModel = arrayList.get(position);
     holder.bind(deliveryOffersViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        DeliveryOrdersBinding deliveryOrdersBinding;

        public CustomView(DeliveryOrdersBinding cardBinding) {
            super(cardBinding.getRoot());
            this.deliveryOrdersBinding = cardBinding;
        }


        public void bind(DeliveryOffersViewModel departmentViewModel)
        {
            this.deliveryOrdersBinding.setDeliveyorders(departmentViewModel);
            deliveryOrdersBinding.executePendingBindings();
        }

        public DeliveryOrdersBinding  getCardBinding()
        {
            return  deliveryOrdersBinding;
        }

    }

}
