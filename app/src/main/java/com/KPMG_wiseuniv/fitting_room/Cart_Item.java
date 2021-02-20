package com.KPMG_wiseuniv.fitting_room;

//class for Cart_Adapter
public class Cart_Item {
    String name;
    String price;
    float price_num;
    public Cart_Item(){}

    public Cart_Item(String name, String price, float price_num){
        this.name=name;
        this.price=price;
        this.price_num=price_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getPrice_num() {
        return price_num;
    }

    public void setPrice_num(float price_num) {
        this.price_num = price_num;
    }
}

