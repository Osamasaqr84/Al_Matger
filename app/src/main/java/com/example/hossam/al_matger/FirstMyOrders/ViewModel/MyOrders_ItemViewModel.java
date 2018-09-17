package com.example.hossam.al_matger.FirstMyOrders.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.FirstMyOrders.Model.My_OrderModel;
import com.example.hossam.al_matger.FirstProductCart.Model.Cart_ItemModel;

import java.util.ArrayList;

public class MyOrders_ItemViewModel {

    private ArrayList<MyOrders_ItemViewModel> items ;
    public MutableLiveData<ArrayList<MyOrders_ItemViewModel>> liveData = new MutableLiveData<>();
    private My_OrderModel  my_orderModel;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    String name,imgpath,rate,ratecount,storename,capitanname,orderstatues,orderdate,price;
    public String getStorename() {
        return storename;
    }
    public void setStorename(String storename) {
        this.storename = storename;
    }
    public String getCapitanname() {
        return capitanname;
    }
    public void setCapitanname(String capitanname) {
        this.capitanname = capitanname;
    }
    public String getOrderstatues() {
        return orderstatues;
    }
    public void setOrderstatues(String orderstatues) {
        this.orderstatues = orderstatues;
    }
    public String getOrderdate() {
        return orderdate;
    }
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public String getRatecount() {
        return ratecount;
    }
    public void setRatecount(String ratecount) {
        this.ratecount = ratecount;
    }


    public MyOrders_ItemViewModel() {
    }
    public MyOrders_ItemViewModel(My_OrderModel myOrderModel) {
        name=myOrderModel.getName();
        imgpath=myOrderModel.getImgpath();
        rate=myOrderModel.getRate();
        ratecount=myOrderModel.getRatecount();
       capitanname=myOrderModel.getCapitanname();
       storename=myOrderModel.getStorename();
       orderdate=myOrderModel.getOrderdate();
       orderstatues=myOrderModel.getOrderdate();
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

    public MutableLiveData<ArrayList<MyOrders_ItemViewModel>> getData()
    {
        items = new ArrayList<>();
        my_orderModel = new My_OrderModel("هاتف اونر 7 سي,ثنائي الشريحة,32 جيجا,رام 3 جبجا ",
                "","5","122","متجر الاحلام ","محمد عبدالمنعم","مكتمل","11/9/2018");
        MyOrders_ItemViewModel cart_itemViewModel = new MyOrders_ItemViewModel(my_orderModel);
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
