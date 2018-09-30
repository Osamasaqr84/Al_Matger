package com.example.hossam.al_matger.FirstPhotographerComments.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import com.example.hossam.al_matger.FirstMyChats.Model.My_ChatModel;
import com.example.hossam.al_matger.FirstPhotographerComments.Model.Photographer_CommentsModel;

import java.util.ArrayList;

public class MyPhotographer_comments_ViewModel {

    private ArrayList<MyPhotographer_comments_ViewModel> items ;
    public MutableLiveData<ArrayList<MyPhotographer_comments_ViewModel>> liveData = new MutableLiveData<>();
    private Photographer_CommentsModel  photographer_commentsModel;


    private String name,imgpath,rate,comment,time;

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

    public MyPhotographer_comments_ViewModel() {
    }

    public MyPhotographer_comments_ViewModel(Photographer_CommentsModel photographer_commentsModel) {
        name=photographer_commentsModel.getName();
        imgpath=photographer_commentsModel.getImgpath();
        comment=photographer_commentsModel.getComment();
        rate=photographer_commentsModel.getRate();
        time=photographer_commentsModel.getTime();

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

    public MutableLiveData<ArrayList<MyPhotographer_comments_ViewModel>> getData()
    {
        items = new ArrayList<>();
        photographer_commentsModel = new Photographer_CommentsModel("حسام  حسين رضوان",
                "","5","مصور ممتاز جدا ","3.34 pm");
        MyPhotographer_comments_ViewModel cart_itemViewModel = new MyPhotographer_comments_ViewModel(photographer_commentsModel);
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        items.add(cart_itemViewModel);
        //items.add(categoryViewModel1);
        liveData.setValue(items);
        // userRepositry = new UserRepositry();
        //  liveData = userRepositry.getData();
        return liveData;
    }

}
