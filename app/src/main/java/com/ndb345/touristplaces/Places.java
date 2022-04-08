package com.ndb345.touristplaces;

public class Places {
    private String category;
    private double living_cost;
    private String name,description;
    private int image;

    public Places(String category,String name, String description, int image,double living_cost) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.image = image;
        this.living_cost = living_cost;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
