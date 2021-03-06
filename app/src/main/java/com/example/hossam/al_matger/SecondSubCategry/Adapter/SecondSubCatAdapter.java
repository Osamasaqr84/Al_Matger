package com.example.hossam.al_matger.SecondSubCategry.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.SecondSubCategry.ViewModel.SubCat_ItemViewModel;
import com.example.hossam.al_matger.databinding.SubCategry2Binding;
import java.util.ArrayList;

public class SecondSubCatAdapter extends RecyclerView.Adapter<SecondSubCatAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<SubCat_ItemViewModel> arrayList;
    private Context context;


    public SecondSubCatAdapter(Context context , ArrayList<SubCat_ItemViewModel> arrayList)
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

        SubCategry2Binding subCategry1Binding = DataBindingUtil.inflate(layoutInflater, R.layout.second_subcategry_adapter_item,parent,false);
        return new CustomView(subCategry1Binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        SubCat_ItemViewModel subCat_itemViewModel = arrayList.get(position);
     holder.bind(subCat_itemViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        SubCategry2Binding subCategry1Binding;

        public CustomView(SubCategry2Binding subCategry1Binding) {
            super(subCategry1Binding.getRoot());
            this.subCategry1Binding = subCategry1Binding;
        }


        public void bind(SubCat_ItemViewModel subCat_itemViewModel)
        {
            this.subCategry1Binding.setSubCategrymodel(subCat_itemViewModel);
            subCategry1Binding.executePendingBindings();
        }

        public SubCategry2Binding  getCardBinding()
        {
            return  subCategry1Binding;
        }

    }

}
