package com.example.miniprojetand;

import java.io.Serializable;

public class Hotel implements Serializable {
    private String name;
    private String location;
    private String price;
    private int imageResId;
    public Hotel() {}
    public Hotel(String name, String location, String price, int imageResId) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) { this.location = location; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public int getImageResId() { return imageResId; }
    public void setImageResId(int imageResId) { this.imageResId = imageResId; }
}
