package com.example.hossam.al_matger.Orders.FirstConfirmOrder.Model;

public class SubCat_ItemModel {

    String name,imgpath,rate,ratecount,price;

    public String getName() {
        return name;
    }

    public SubCat_ItemModel(String name, String imgpath, String rate, String ratecount, String price) {
        this.name = name;
        this.imgpath = imgpath;
        this.rate = rate;
        this.ratecount = ratecount;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
