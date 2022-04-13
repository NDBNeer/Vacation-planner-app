package com.ndb345.touristplaces;

import java.util.ArrayList;

public class BookedPlaceList {
    private double living_cost;
    private String name;
    private int novisitors;

    public BookedPlaceList(double living_cost, String name, int novisitors) {
        this.living_cost = living_cost;
        this.name = name;
        this.novisitors = novisitors;
    }

    public double getLiving_cost() {
        return living_cost;
    }

    public void setLiving_cost(double living_cost) {
        this.living_cost = living_cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNovisitors() {
        return novisitors;
    }

    public void setNovisitors(int novisitors) {
        this.novisitors = novisitors;
    }
}
