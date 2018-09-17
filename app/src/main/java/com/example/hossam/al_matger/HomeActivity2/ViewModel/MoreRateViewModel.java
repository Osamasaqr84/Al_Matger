package com.example.hossam.al_matger.HomeActivity2.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import com.example.hossam.al_matger.HomeActivity1.Model.DepartmentModel;
import com.example.hossam.al_matger.HomeActivity2.Model.MorerateModel;

import java.util.ArrayList;

public class MoreRateViewModel {

    private ArrayList<MoreRateViewModel> items ;
    public MutableLiveData<ArrayList<MoreRateViewModel>> liveData = new MutableLiveData<>();
    private MorerateModel morerateModel;

    String name,imgpath,depart;
    float rate;
    int ratecounter;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getRatecounter() {
        return ratecounter;
    }

    public void setRatecounter(int ratecounter) {
        this.ratecounter = ratecounter;
    }

    public MoreRateViewModel() {
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

    public MoreRateViewModel(MorerateModel  moreRateViewModel) {

        name=moreRateViewModel.getName();
        imgpath=moreRateViewModel.getImgpath();
        rate=moreRateViewModel.getRate();
        ratecounter=moreRateViewModel.getRatecounter();
        depart=moreRateViewModel.getDepart();
    }

    public MutableLiveData<ArrayList<MoreRateViewModel>> getData()
    {
        items = new ArrayList<>();
        morerateModel = new MorerateModel("Hardenies ","path","مطاعم",5,120);
        MoreRateViewModel moreRateViewModel = new MoreRateViewModel(morerateModel);
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(moreRateViewModel);
        items.add(moreRateViewModel);
        items.add(moreRateViewModel);
        items.add(moreRateViewModel);
        items.add(moreRateViewModel);
        items.add(moreRateViewModel);
        items.add(moreRateViewModel);

        //items.add(categoryViewModel1);
        liveData.setValue(items);
        // userRepositry = new UserRepositry();
        //  liveData = userRepositry.getData();
        return liveData;
    }

}
