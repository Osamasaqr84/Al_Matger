package com.example.hossam.al_matger.HomeActivity2.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.al_matger.HomeActivity2.ViewModel.DepartmentViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.DepartmentPinding;

import java.util.ArrayList;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<DepartmentViewModel> arrayList;
    private Context context;


    public DepartmentAdapter(Context context , ArrayList<DepartmentViewModel> arrayList)
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

        DepartmentPinding departmentPinding = DataBindingUtil.inflate(layoutInflater, R.layout.home2_depart_item,parent,false);
        return new CustomView(departmentPinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

     DepartmentViewModel categoryViewModel = arrayList.get(position);
     holder.bind(categoryViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        DepartmentPinding cardBinding;

        public CustomView(DepartmentPinding cardBinding) {
            super(cardBinding.getRoot());
            this.cardBinding = cardBinding;
        }


        public void bind(DepartmentViewModel departmentViewModel)
        {
            this.cardBinding.setDepartmentmodel(departmentViewModel);
            cardBinding.executePendingBindings();
        }

        public DepartmentPinding  getCardBinding()
        {
            return  cardBinding;
        }

    }

}
