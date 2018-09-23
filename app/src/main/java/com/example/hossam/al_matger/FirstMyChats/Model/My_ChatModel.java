package com.example.hossam.al_matger.FirstMyChats.Model;

public class My_ChatModel {

    String name,imgpath,productname,deliveryname,time;

    public My_ChatModel(String name, String imgpath, String productname, String deliveryname, String time) {
        this.name = name;
        this.imgpath = imgpath;
        this.productname = productname;
        this.deliveryname = deliveryname;
        this.time = time;
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

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDeliveryname() {
        return deliveryname;
    }

    public void setDeliveryname(String deliveryname) {
        this.deliveryname = deliveryname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
