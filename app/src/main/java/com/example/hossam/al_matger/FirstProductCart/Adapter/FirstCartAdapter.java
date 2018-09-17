package com.example.hossam.al_matger.FirstProductCart.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.FirstProductCart.ViewModel.Cart_ItemViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.SecondSubCategry.ViewModel.SubCat_ItemViewModel;
import com.example.hossam.al_matger.databinding.ProductCartBinding;
import com.example.hossam.al_matger.databinding.SubCategry2Binding;
import java.util.ArrayList;

public class FirstCartAdapter extends RecyclerView.Adapter<FirstCartAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<Cart_ItemViewModel> arrayList;
    private Context context;


    public FirstCartAdapter(Context context , ArrayList<Cart_ItemViewModel> arrayList)
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

        ProductCartBinding productCartBinding = DataBindingUtil.inflate(layoutInflater, R.layout.first_product_cart_adapter_item,parent,false);
        return new CustomView(productCartBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        Cart_ItemViewModel cart_itemViewModel = arrayList.get(position);
     holder.bind(cart_itemViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        ProductCartBinding productCartBinding;

        public CustomView(ProductCartBinding subCategry1Binding) {
            super(subCategry1Binding.getRoot());
            this.productCartBinding = subCategry1Binding;
        }


        public void bind(Cart_ItemViewModel cart_itemViewModel)
        {
            this.productCartBinding.setCartmodel(cart_itemViewModel);
            productCartBinding.executePendingBindings();
        }

        public ProductCartBinding  getCardBinding()
        {
            return  productCartBinding;
        }

    }

}
