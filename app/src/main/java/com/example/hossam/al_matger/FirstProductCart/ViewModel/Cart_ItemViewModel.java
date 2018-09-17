package com.example.hossam.al_matger.FirstProductCart.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.FirstProductCart.Model.Cart_ItemModel;
import com.example.hossam.al_matger.SecondSubCategry.Model.SubCat_ItemModel;

import java.util.ArrayList;

public class Cart_ItemViewModel {

    private ArrayList<Cart_ItemViewModel> items ;
    public MutableLiveData<ArrayList<Cart_ItemViewModel>> liveData = new MutableLiveData<>();
    private Cart_ItemModel  cart_itemModel;

    public String getPriceforone() {
        return priceforone;
    }

    public void setPriceforone(String priceforone) {
        this.priceforone = priceforone;
    }

    String name,imgpath,rate,ratecount,price,priceforone;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Cart_ItemViewModel() {
    }
    public Cart_ItemViewModel(Cart_ItemModel cart_itemModel) {
        name=cart_itemModel.getName();
        imgpath=cart_itemModel.getImgpath();
        rate=cart_itemModel.getRate();
        ratecount=cart_itemModel.getRatecount();
        price=cart_itemModel.getPrice();
        priceforone=cart_itemModel.getPriceforone();
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



    public MutableLiveData<ArrayList<Cart_ItemViewModel>> getData()
    {
        items = new ArrayList<>();
        cart_itemModel = new Cart_ItemModel("هاتف اونر 7 سي,ثنائي الشريحة,32 جيجا,رام 3 جبجا ",
                "","5","55","5.849.00ريال");
        Cart_ItemViewModel cart_itemViewModel = new Cart_ItemViewModel(cart_itemModel);
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
