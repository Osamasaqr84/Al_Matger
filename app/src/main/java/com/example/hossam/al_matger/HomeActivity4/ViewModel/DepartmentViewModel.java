package com.example.hossam.al_matger.HomeActivity4.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.HomeActivity4.Model.DepartmentModel;

import java.util.ArrayList;

public class DepartmentViewModel {

    private ArrayList<DepartmentViewModel> items ;
    public MutableLiveData<ArrayList<DepartmentViewModel>> liveData = new MutableLiveData<>();
    private DepartmentModel DepartmentModel;

    String name,imgpath;

    public DepartmentViewModel() {
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

    public DepartmentViewModel(DepartmentModel  departmentModel) {

        name=departmentModel.getName();
        imgpath=departmentModel.getImgpath();
    }

    public MutableLiveData<ArrayList<DepartmentViewModel>> getData()
    {
        items = new ArrayList<>();
        DepartmentModel = new DepartmentModel("مطاعم ");
        DepartmentViewModel categoryViewModel = new DepartmentViewModel(DepartmentModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);

        liveData.setValue(items);

        return liveData;
    }

}
