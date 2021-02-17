package com.KPMG_wiseuniv.fitting_room;

import java.util.ArrayList;

public class ManageFurniture {
    private static ManageFurniture manageFurniture=null;
    Furniture furniture;
    ArrayList<Furniture> total_furniture;
    String date;
    String big_cat;
    String sec_cat;
    String th_cat;
    String style;
    String function;
    String price;
    public static ManageFurniture getInstance(){
        if(manageFurniture==null){
            manageFurniture=new ManageFurniture();
        }
        return manageFurniture;
    }
    private ManageFurniture(){
        furniture=new Furniture();
        total_furniture=new ArrayList<>();
    }


    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public ArrayList<Furniture> getTotal_furniture() {
        return total_furniture;
    }

    public void setTotal_furniture(ArrayList<Furniture> total_furniture) {
        this.total_furniture = total_furniture;
    }

    public void addnewdata(Furniture newdata){
        this.total_furniture.add(newdata);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBig_cat() {
        return big_cat;
    }

    public void setBig_cat(String big_cat) {
        this.big_cat = big_cat;
    }

    public String getSec_cat() {
        return sec_cat;
    }

    public void setSec_cat(String sec_cat) {
        this.sec_cat = sec_cat;
    }

    public String getTh_cat() {
        return th_cat;
    }

    public void setTh_cat(String th_cat) {
        this.th_cat = th_cat;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
