package com.example.hossam.al_matger.FirstMyOrders.Model;

public class My_OrderModel {

    String name,imgpath,rate,ratecount,storename,capitanname,orderstatues,orderdate,price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public My_OrderModel(String name, String imgpath, String rate, String ratecount, String storename, String capitanname, String orderstatues, String orderdate) {
        this.name = name;
        this.imgpath = imgpath;
        this.rate = rate;
        this.ratecount = ratecount;
        this.storename = storename;
        this.capitanname = capitanname;
        this.orderstatues = orderstatues;
        this.orderdate = orderdate;
    }

    public String getName() {
        return name;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getCapitanname() {
        return capitanname;
    }

    public void setCapitanname(String capitanname) {
        this.capitanname = capitanname;
    }

    public String getOrderstatues() {
        return orderstatues;
    }

    public void setOrderstatues(String orderstatues) {
        this.orderstatues = orderstatues;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
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

}
