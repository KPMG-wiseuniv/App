package com.KPMG_wiseuniv.fitting_room;

public class Furniture {
    String date;
    String big_cat;
    String sec_cat;
    String th_cat;
    String style;
    String function;
    String price;

    public Furniture(){}
    public Furniture(String date, String big_cat, String sec_cat, String th_cat, String style, String function, String price) {
        this.date=date;
        this.big_cat = big_cat;
        this.sec_cat = sec_cat;
        this.th_cat = th_cat;
        this.style = style;
        this.function = function;
        this.price = price;
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
