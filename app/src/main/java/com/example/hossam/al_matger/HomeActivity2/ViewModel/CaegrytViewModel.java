package com.example.hossam.al_matger.HomeActivity2.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.HomeActivity1.Model.DepartmentModel;

import java.util.ArrayList;

public class CaegrytViewModel {

    private ArrayList<CaegrytViewModel> items ;
    public MutableLiveData<ArrayList<CaegrytViewModel>> liveData = new MutableLiveData<>();
    private DepartmentModel DepartmentModel;

    String name,imgpath;

    public CaegrytViewModel() {
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

    public CaegrytViewModel(DepartmentModel  departmentModel) {

        name=departmentModel.getName();
        imgpath=departmentModel.getImgpath();
    }

    public MutableLiveData<ArrayList<CaegrytViewModel>> getData()
    {
        items = new ArrayList<>();
        DepartmentModel = new DepartmentModel("مطاعم ");
        CaegrytViewModel categoryViewModel = new CaegrytViewModel(DepartmentModel);
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
