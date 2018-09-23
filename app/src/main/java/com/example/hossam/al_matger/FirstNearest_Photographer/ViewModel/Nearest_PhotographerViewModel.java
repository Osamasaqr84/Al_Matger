package com.example.hossam.al_matger.FirstNearest_Photographer.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.FirstMyChats.Model.My_ChatModel;
import com.example.hossam.al_matger.FirstNearest_Photographer.Model.Nearest_Photographer_Model;

import java.util.ArrayList;

public class Nearest_PhotographerViewModel {

    private ArrayList<Nearest_PhotographerViewModel> items ;
    public MutableLiveData<ArrayList<Nearest_PhotographerViewModel>> liveData = new MutableLiveData<>();
    private Nearest_Photographer_Model  nearest_photographer_model;


    private String name,imgpath,rate,ratecount,description,img_num;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_num() {
        return img_num;
    }

    public void setImg_num(String img_num) {
        this.img_num = img_num;
    }

    public Nearest_PhotographerViewModel() {
    }

    public Nearest_PhotographerViewModel(Nearest_Photographer_Model nearest_photographer_model) {
        name=nearest_photographer_model.getName();
        imgpath=nearest_photographer_model.getImgpath();
       rate = nearest_photographer_model.getRate();
       ratecount = nearest_photographer_model.getRatecount();
       description = nearest_photographer_model.getDescription();
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

    public MutableLiveData<ArrayList<Nearest_PhotographerViewModel>> getData()
    {
        items = new ArrayList<>();
        nearest_photographer_model = new Nearest_Photographer_Model("أحمد زكربا عبدالتواب" ,"","5","220"
                ,"نبذة عن المصورنبذة عن المصورنبذة عن المصورنبذة عن المصور","450"
        );

        Nearest_PhotographerViewModel cart_itemViewModel = new Nearest_PhotographerViewModel(nearest_photographer_model);
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
