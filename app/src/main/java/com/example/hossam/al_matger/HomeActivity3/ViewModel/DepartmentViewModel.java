package com.example.hossam.al_matger.HomeActivity3.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.HomeActivity3.Model.DepartmentModel;

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
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(categoryViewModel);
        items.add(categoryViewModel);
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
