package com.example.hossam.al_matger.FirstProductDetails.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.hossam.al_matger.FirstResturantList.ViewModel.Resturant_list_ItemViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.ResturantMenu1Binding;
import java.util.ArrayList;

public class ResturantListAdapter extends RecyclerView.Adapter<ResturantListAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<Resturant_list_ItemViewModel> arrayList;
    private Context context;


    public ResturantListAdapter(Context context , ArrayList<Resturant_list_ItemViewModel> arrayList)
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
        ResturantMenu1Binding subCategry1Binding = DataBindingUtil.inflate(layoutInflater, R.layout.first_resturant_adapter_item,parent,false);
        return new CustomView(subCategry1Binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

     Resturant_list_ItemViewModel resturant_list_itemViewModel = arrayList.get(position);
     holder.bind(resturant_list_itemViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        ResturantMenu1Binding resturantMenu1Binding;

        public CustomView(ResturantMenu1Binding subCategry1Binding) {
            super(subCategry1Binding.getRoot());
            this.resturantMenu1Binding = subCategry1Binding;
        }


        public void bind(Resturant_list_ItemViewModel subCat_itemViewModel)
        {
            this.resturantMenu1Binding.setResturantlistmodel(subCat_itemViewModel);
            resturantMenu1Binding.executePendingBindings();
        }

        public ResturantMenu1Binding  getCardBinding()
        {
            return  resturantMenu1Binding;
        }

    }

}
