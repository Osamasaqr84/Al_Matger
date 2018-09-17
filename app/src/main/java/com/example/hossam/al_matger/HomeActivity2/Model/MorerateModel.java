package com.example.hossam.al_matger.HomeActivity2.Model;

public class MorerateModel {

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

    public String getName() {
        return name;
    }

    public MorerateModel(String name) {
        this.name = name;
    }

    public MorerateModel(String name, String imgpath, String depart, float rate, int ratecounter) {
        this.name = name;
        this.imgpath = imgpath;
        this.depart = depart;
        this.rate = rate;
        this.ratecounter = ratecounter;
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
