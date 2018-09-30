package com.example.hossam.al_matger.FirstPhotographerComments.Model;

public class Photographer_CommentsModel {

    private String name,imgpath,rate,comment,time;

    public Photographer_CommentsModel(String name, String imgpath, String rate, String comment, String time) {
        this.name = name;
        this.imgpath = imgpath;
        this.rate = rate;
        this.comment = comment;
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
