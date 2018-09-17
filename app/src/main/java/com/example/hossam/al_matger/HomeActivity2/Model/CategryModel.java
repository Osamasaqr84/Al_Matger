package com.example.hossam.al_matger.HomeActivity2.Model;

public class CategryModel {

    String name,imgpath;

    public String getName() {
        return name;
    }

    public CategryModel(String name) {
        this.name = name;
    }

    public CategryModel(String name, String imgpath) {
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
