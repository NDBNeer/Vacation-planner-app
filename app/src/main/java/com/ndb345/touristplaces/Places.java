package com.ndb345.touristplaces;

import java.util.ArrayList;

public class Places {
    private String category;
    private double living_cost;
    private String name,description;
    private int image1;
    private ArrayList<Integer> image;

    public Places(String category, String name, String description, int image1, ArrayList<Integer> image, double living_cost) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.image1 = image1;
        this.image = image;
        this.living_cost = living_cost;
    }
    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public double getLiving_cost() {
        return living_cost;
    }

    public void setLiving_cost(double living_cost) {
        this.living_cost = living_cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getImage() {
        return image;
    }

    public void setImage(ArrayList<Integer> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Places{" +
                "category='" + category + '\'' +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", living_cost=" + living_cost +
                '}';
    }
}
