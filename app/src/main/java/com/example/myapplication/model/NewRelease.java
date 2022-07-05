package com.example.myapplication.model;

public class NewRelease {
    private String name;
    private int imageurl;
    private String gender;
    private String price;

    public NewRelease(String name, int imageurl, String gender, String price) {
        this.name = name;
        this.imageurl = imageurl;
        this.gender = gender;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
