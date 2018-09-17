package com.example.hossam.al_matger.HomeActivity4.Model;

public class OfferModel {

    String name,imgpath,storename;
    String oldprice,newprice;

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }

    public String getNewprice() {
        return newprice;
    }

    public void setNewprice(String newprice) {
        this.newprice = newprice;
    }

    public String getName() {
        return name;
    }

    public OfferModel(String name) {
        this.name = name;
    }

    public OfferModel(String name, String storename, String oldprice, String newprice) {
        this.name = name;
        this.storename = storename;
        this.oldprice = oldprice;
        this.newprice = newprice;
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
