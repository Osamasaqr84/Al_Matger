package com.example.hossam.al_matger.FirstMyOrders.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.FirstMyOrders.ViewModel.MyOrders_ItemViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.MyOrdersBinding;

import java.util.ArrayList;

public class FirstMyOrderAdapter extends RecyclerView.Adapter<FirstMyOrderAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<MyOrders_ItemViewModel> arrayList;
    private Context context;


    public FirstMyOrderAdapter(Context context , ArrayList<MyOrders_ItemViewModel> arrayList)
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

        MyOrdersBinding myOrdersBinding = DataBindingUtil.inflate(layoutInflater, R.layout.first_myorder_adapter_item2,parent,false);
        return new CustomView(myOrdersBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        MyOrders_ItemViewModel myOrders_itemViewModel = arrayList.get(position);
     holder.bind(myOrders_itemViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        MyOrdersBinding myOrdersBinding;

        public CustomView(MyOrdersBinding myOrdersBinding) {
            super(myOrdersBinding.getRoot());
            this.myOrdersBinding = myOrdersBinding;
        }


        public void bind(MyOrders_ItemViewModel myOrders_itemViewModel)
        {
            this.myOrdersBinding.setOrdermodel(myOrders_itemViewModel);
            myOrdersBinding.executePendingBindings();
        }

        public MyOrdersBinding  getCardBinding()
        {
            return  myOrdersBinding;
        }

    }

}
