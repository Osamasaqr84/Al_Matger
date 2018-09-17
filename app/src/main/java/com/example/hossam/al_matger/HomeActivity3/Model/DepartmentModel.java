package com.example.hossam.al_matger.HomeActivity3.Model;

public class DepartmentModel {

    String name,imgpath;

    public String getName() {
        return name;
    }

    public DepartmentModel(String name) {
        this.name = name;
    }

    public DepartmentModel(String name, String imgpath) {
        this.name = name;
        this.imgpath = imgpath;
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
}
