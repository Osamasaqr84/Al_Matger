package com.example.hossam.al_matger.FirstDeliveryOffers.Model;

public class DeliveryOffers {

    String name,rate,ratecount,cost,distance;

    public DeliveryOffers(String name, String rate, String ratecount, String cost, String distance) {
        this.name = name;
        this.rate = rate;
        this.ratecount = ratecount;
        this.cost = cost;
        this.distance = distance;
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
}
