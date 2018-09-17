package com.example.hossam.al_matger.FirstProductDetails.Model;

public class Resturant_list_itemModel {

    String name,imgpath,logopath,rate,place,commentcounter,likecounter;

    public String getName() {
        return name;
    }

    public Resturant_list_itemModel(String name, String imgpath, String logopath, String rate, String commentcounter,String likecounter,String place) {
        this.name = name;
        this.imgpath = imgpath;
        this.rate = rate;
        this.place = place;
        this.commentcounter = commentcounter;
        this.likecounter = likecounter;
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

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCommentcounter() {
        return commentcounter;
    }

    public void setCommentcounter(String commentcounter) {
        this.commentcounter = commentcounter;
    }

    public String getLikecounter() {
        return likecounter;
    }

    public void setLikecounter(String likecounter) {
        this.likecounter = likecounter;
    }
}
