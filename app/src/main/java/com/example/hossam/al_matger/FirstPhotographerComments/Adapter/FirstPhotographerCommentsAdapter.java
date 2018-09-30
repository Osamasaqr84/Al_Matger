package com.example.hossam.al_matger.FirstPhotographerComments.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.hossam.al_matger.FirstMyChats.ViewModel.MyChats_ItemViewModel;
import com.example.hossam.al_matger.FirstPhotographerComments.ViewModel.MyPhotographer_comments_ViewModel;
import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.databinding.CommentBinding;

import java.util.ArrayList;

public class FirstPhotographerCommentsAdapter extends RecyclerView.Adapter<FirstPhotographerCommentsAdapter.CustomView> {

    private LayoutInflater layoutInflater;
    private ArrayList<MyPhotographer_comments_ViewModel> arrayList;
    private Context context;


    public FirstPhotographerCommentsAdapter(Context context , ArrayList<MyPhotographer_comments_ViewModel> arrayList)
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

        CommentBinding myChatBinding = DataBindingUtil.inflate(layoutInflater, R.layout.first_photographer_comments_adapter_item,parent,false);
        return new CustomView(myChatBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        MyPhotographer_comments_ViewModel myOrders_itemViewModel = arrayList.get(position);
     holder.bind(myOrders_itemViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        CommentBinding myChatBinding;

        public CustomView(CommentBinding myChatBinding) {
            super(myChatBinding.getRoot());
            this.myChatBinding = myChatBinding;
        }


        public void bind(MyPhotographer_comments_ViewModel myOrders_itemViewModel)
        {
            this.myChatBinding.setPhotocommentitem(myOrders_itemViewModel);
            myChatBinding.executePendingBindings();
        }

        public CommentBinding  getCardBinding()
        {
            return  myChatBinding;
        }
    }

}
