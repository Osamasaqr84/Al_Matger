package com.example.hossam.al_matger.FirstMyChats.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.hossam.al_matger.FirstMyChats.ViewModel.MyChats_ItemViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.MyChatBinding;

import java.util.ArrayList;

public class FirstMyChatAdapter extends RecyclerView.Adapter<FirstMyChatAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<MyChats_ItemViewModel> arrayList;
    private Context context;


    public FirstMyChatAdapter(Context context , ArrayList<MyChats_ItemViewModel> arrayList)
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

        MyChatBinding myChatBinding = DataBindingUtil.inflate(layoutInflater, R.layout.first_mychat_adapter_item,parent,false);
        return new CustomView(myChatBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        MyChats_ItemViewModel myOrders_itemViewModel = arrayList.get(position);
     holder.bind(myOrders_itemViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        MyChatBinding myChatBinding;

        public CustomView(MyChatBinding myChatBinding) {
            super(myChatBinding.getRoot());
            this.myChatBinding = myChatBinding;
        }


        public void bind(MyChats_ItemViewModel myOrders_itemViewModel)
        {
            this.myChatBinding.setMychatitem(myOrders_itemViewModel);
            myChatBinding.executePendingBindings();
        }

        public MyChatBinding  getCardBinding()
        {
            return  myChatBinding;
        }
    }

}
