package com.example.hossam.al_matger.FirstPhotographer_Details.Model;

public class Nearest_Photographer_Model {

    private String name,imgpath,rate,ratecount,description,img_num;

    public Nearest_Photographer_Model(String name, String imgpath, String rate, String ratecount, String description, String img_num) {
        this.name = name;
        this.imgpath = imgpath;
        this.rate = rate;
        this.ratecount = ratecount;
        this.description = description;
        this.img_num = img_num;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_num() {
        return img_num;
    }

    public void setImg_num(String img_num) {
        this.img_num = img_num;
    }
}
