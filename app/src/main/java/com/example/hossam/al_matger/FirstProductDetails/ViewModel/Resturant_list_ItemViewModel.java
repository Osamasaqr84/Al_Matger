package com.example.hossam.al_matger.FirstProductDetails.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.FirstResturantList.Model.Resturant_list_itemModel;
import com.example.hossam.al_matger.SecondSubCategry.Model.SubCat_ItemModel;

import java.util.ArrayList;

public class Resturant_list_ItemViewModel {

    private ArrayList<Resturant_list_ItemViewModel> items ;
    public MutableLiveData<ArrayList<Resturant_list_ItemViewModel>> liveData = new MutableLiveData<>();
    private Resturant_list_itemModel resturant_list_itemModel;



    String name,imgpath,logopath,rate,place,commentcounter,likecounter;

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCommentcounter() {
        return commentcounter;
    }

    public void setCommentcounter(String commentcounter) {
        this.commentcounter = commentcounter;
    }

    public String getLikecounter() {
        return likecounter;
    }

    public void setLikecounter(String likecounter) {
        this.likecounter = likecounter;
    }

    public Resturant_list_ItemViewModel() {
    }
    public Resturant_list_ItemViewModel(Resturant_list_itemModel resturant_list_itemModel) {
        name=resturant_list_itemModel.getName();
        imgpath=resturant_list_itemModel.getImgpath();
        rate=resturant_list_itemModel.getRate();
        place=resturant_list_itemModel.getPlace();
        commentcounter=resturant_list_itemModel.getCommentcounter();
        likecounter=resturant_list_itemModel.getLikecounter();
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



    public MutableLiveData<ArrayList<Resturant_list_ItemViewModel>> getData()
    {
        items = new ArrayList<>();
        resturant_list_itemModel = new Resturant_list_itemModel("PIZZA HUT" ,"" ,"" ,"4",
                                                      "81","225","AlKASDVS");

        Resturant_list_ItemViewModel resturantlist_itemViewModel = new Resturant_list_ItemViewModel(resturant_list_itemModel);
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(resturantlist_itemViewModel);
        items.add(resturantlist_itemViewModel);
        items.add(resturantlist_itemViewModel);
        items.add(resturantlist_itemViewModel);
        items.add(resturantlist_itemViewModel);
        items.add(resturantlist_itemViewModel);

        //items.add(categoryViewModel1);
        liveData.setValue(items);
        // userRepositry = new UserRepositry();
        //  liveData = userRepositry.getData();
        return liveData;
    }

}
