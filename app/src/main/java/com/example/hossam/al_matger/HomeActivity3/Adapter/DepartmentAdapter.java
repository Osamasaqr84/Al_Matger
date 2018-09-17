package com.example.hossam.al_matger.HomeActivity3.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.hossam.al_matger.databinding.DepartBinding3;

import com.example.hossam.al_matger.HomeActivity3.ViewModel.DepartmentViewModel;
import com.example.hossam.al_matger.R;
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

        DepartBinding3 departBinding3 = DataBindingUtil.inflate(layoutInflater, R.layout.home3_depart_model,parent,false);
        return new CustomView(departBinding3);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        DepartmentViewModel departmentViewModel = arrayList.get(position);
     holder.bind(departmentViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        DepartBinding3 departBinding3;

        public CustomView(DepartBinding3 departBinding3) {
            super(departBinding3.getRoot());
            this.departBinding3 = departBinding3;
        }


        public void bind(DepartmentViewModel departmentViewModel)
        {
            this.departBinding3.setDepartmentmodel(departmentViewModel);
            departBinding3.executePendingBindings();
        }

        public DepartBinding3  getCardBinding()
        {
            return  departBinding3;
        }

    }

}
