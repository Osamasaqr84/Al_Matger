package com.example.hossam.al_matger.Orders.FirstConfirmOrder.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.FirstSubCategry.Model.SubCat_ItemModel;
import com.example.hossam.al_matger.HomeActivity1.Model.DepartmentModel;

import java.util.ArrayList;

public class SubCat_ItemViewModel {

    private ArrayList<SubCat_ItemViewModel> items ;
    public MutableLiveData<ArrayList<SubCat_ItemViewModel>> liveData = new MutableLiveData<>();
    private SubCat_ItemModel subCat_itemModel;

    String name,imgpath,rate,ratecount,price;

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

    public SubCat_ItemViewModel() {
    }
    public SubCat_ItemViewModel(SubCat_ItemModel subCat_itemModel) {
        name=subCat_itemModel.getName();
        imgpath=subCat_itemModel.getImgpath();
        rate=subCat_itemModel.getRate();
        ratecount=subCat_itemModel.getRatecount();
        price=subCat_itemModel.getPrice();
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

    public SubCat_ItemViewModel(DepartmentModel  departmentModel) {

        name=departmentModel.getName();
        imgpath=departmentModel.getImgpath();
    }

    public MutableLiveData<ArrayList<SubCat_ItemViewModel>> getData()
    {
        items = new ArrayList<>();
        subCat_itemModel = new SubCat_ItemModel("هاتف اونر 7 سي,ثنائي الشريحة,32 جيجا,رام 3 جبجا ",
                "","5","55","5.849.00ريال");
        SubCat_ItemViewModel subCat_itemViewModel = new SubCat_ItemViewModel(subCat_itemModel);
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(subCat_itemViewModel);
        items.add(subCat_itemViewModel);
        items.add(subCat_itemViewModel);
        items.add(subCat_itemViewModel);
        items.add(subCat_itemViewModel);
        items.add(subCat_itemViewModel);

        //items.add(categoryViewModel1);
        liveData.setValue(items);
        // userRepositry = new UserRepositry();
        //  liveData = userRepositry.getData();
        return liveData;
    }

}
