package com.example.hossam.al_matger.FirstMyChats.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.FirstMyChats.Model.My_ChatModel;
import com.example.hossam.al_matger.FirstMyOrders.Model.My_OrderModel;

import java.util.ArrayList;

public class MyChats_ItemViewModel {

    private ArrayList<MyChats_ItemViewModel> items ;
    public MutableLiveData<ArrayList<MyChats_ItemViewModel>> liveData = new MutableLiveData<>();
    private My_ChatModel  my_chatModel;


    private String name,imgpath,productname,deliveryname,time;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDeliveryname() {
        return deliveryname;
    }

    public void setDeliveryname(String deliveryname) {
        this.deliveryname = deliveryname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public MyChats_ItemViewModel() {
    }

    public MyChats_ItemViewModel(My_ChatModel my_chatModel) {
        name=my_chatModel.getName();
        imgpath=my_chatModel.getImgpath();
       deliveryname =my_chatModel.getDeliveryname();
       productname =my_chatModel.getProductname();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public MutableLiveData<ArrayList<MyChats_ItemViewModel>> getData()
    {
        items = new ArrayList<>();
        my_chatModel = new My_ChatModel("حسام  حسين رضوان",
                "","موبايل هواوي موديل 2010","أحمد سعيد عبدالتواب","3.34 pm");
        MyChats_ItemViewModel cart_itemViewModel = new MyChats_ItemViewModel(my_chatModel);
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        //items.add(categoryViewModel1);
        liveData.setValue(items);
        // userRepositry = new UserRepositry();
        //  liveData = userRepositry.getData();
        return liveData;
    }

}
