package com.example.catagories;

public class CatagoriesModel {
    String img,name;

    public CatagoriesModel() {
    }

    public CatagoriesModel(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
