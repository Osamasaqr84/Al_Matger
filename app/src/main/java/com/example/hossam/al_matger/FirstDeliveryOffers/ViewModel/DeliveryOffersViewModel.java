package com.example.hossam.al_matger.FirstDeliveryOffers.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.hossam.al_matger.FirstDeliveryOffers.Model.DeliveryOffers;
import com.example.hossam.al_matger.HomeActivity1.Model.DepartmentModel;

import java.util.ArrayList;

public class DeliveryOffersViewModel {

    private ArrayList<DeliveryOffersViewModel> items ;
    public MutableLiveData<ArrayList<DeliveryOffersViewModel>> liveData = new MutableLiveData<>();
    private DeliveryOffers deliveryOffers;

    String name,rate,ratecount,cost,distance;

    public DeliveryOffersViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public DeliveryOffersViewModel(DeliveryOffers deliveryOffers) {

        name=deliveryOffers.getName();
        rate=deliveryOffers.getRate();
        ratecount=deliveryOffers.getRatecount();
        cost=deliveryOffers.getCost();
        distance=deliveryOffers.getDistance();
    }

    public MutableLiveData<ArrayList<DeliveryOffersViewModel>> getData()
    {
        items = new ArrayList<>();
        deliveryOffers = new DeliveryOffers("اسامه عبدالمنعم","5","120","34 ر.س","2.4 كم");
        DeliveryOffersViewModel categoryViewModel = new DeliveryOffersViewModel(deliveryOffers);
        //CategoryViewModel categoryViewModel1 = new CategoryViewModel();
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        items.add(categoryViewModel);
        //items.add(categoryViewModel1);
        liveData.setValue(items);
        // userRepositry = new UserRepositry();
        //  liveData = userRepositry.getData();
        return liveData;
    }

}
