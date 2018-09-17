package com.example.hossam.al_matger.HomeActivity4.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.HomeActivity4.Model.DepartmentModel;
import com.example.hossam.al_matger.HomeActivity4.Model.OfferModel;

import java.util.ArrayList;

public class OffersViewModel {

    private ArrayList<OffersViewModel> items ;
    public MutableLiveData<ArrayList<OffersViewModel>> liveData = new MutableLiveData<>();
    private OfferModel offerModel;

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getOldprice() {
        return oldprice+"";
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }

    public String getNewprice() {
        return newprice+"";
    }

    public void setNewprice(String newprice) {
        this.newprice = newprice;
    }

    String name,imgpath,storename;
    String oldprice,newprice;
    public OffersViewModel() {
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

    public OffersViewModel(OfferModel  offersViewModel) {

        name=offersViewModel.getName();
        storename=offersViewModel.getStorename();
        newprice =offersViewModel.getNewprice();
        oldprice = offersViewModel.getOldprice();
    }

    public MutableLiveData<ArrayList<OffersViewModel>> getData()
    {
        items = new ArrayList<>();
        offerModel = new OfferModel("ايقون 6 ابيض","متاجر","35 ريال","40 ريال ");
        OffersViewModel categoryViewModel = new OffersViewModel(offerModel);
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        //items.add(categoryViewModel1);
        liveData.setValue(items);
        // userRepositry = new UserRepositry();
        //  liveData = userRepositry.getData();
        return liveData;
    }

}
