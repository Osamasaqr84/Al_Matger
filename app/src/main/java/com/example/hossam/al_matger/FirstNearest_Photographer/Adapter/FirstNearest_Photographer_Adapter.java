package com.example.hossam.al_matger.FirstNearest_Photographer.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.hossam.al_matger.FirstMyChats.ViewModel.MyChats_ItemViewModel;
import com.example.hossam.al_matger.FirstNearest_Photographer.ViewModel.Nearest_PhotographerViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.NearestPhotoBinding;

import java.util.ArrayList;

public class FirstNearest_Photographer_Adapter extends RecyclerView.Adapter<FirstNearest_Photographer_Adapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<Nearest_PhotographerViewModel> arrayList;
    private Context context;


    public FirstNearest_Photographer_Adapter(Context context , ArrayList<Nearest_PhotographerViewModel> arrayList)
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

        NearestPhotoBinding nearestPhotoBinding = DataBindingUtil.inflate(layoutInflater, R.layout.first_nearest_photographer_adapter_item,parent,false);
        return new CustomView(nearestPhotoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        Nearest_PhotographerViewModel  nearest_photographerViewModel = arrayList.get(position);
     holder.bind(nearest_photographerViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        NearestPhotoBinding nearestPhotoBinding;

        public CustomView(NearestPhotoBinding nearestPhotoBinding) {
            super(nearestPhotoBinding.getRoot());
            this.nearestPhotoBinding = nearestPhotoBinding;
        }

        public void bind(Nearest_PhotographerViewModel photographerViewModel)
        {
            this.nearestPhotoBinding.setNearestphotographer(photographerViewModel);
            nearestPhotoBinding.executePendingBindings();
        }

        public NearestPhotoBinding  getCardBinding()
        {
            return  nearestPhotoBinding;
        }
    }

}
