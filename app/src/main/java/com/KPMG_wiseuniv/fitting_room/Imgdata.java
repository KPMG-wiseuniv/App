package com.KPMG_wiseuniv.fitting_room;

public class Imgdata {
    String imgname;
    String bigcategory;
    String middlecategory;
    String furniturename;
    String style;
    String selectfd;
    int price;
    int color;
    String detail;
    String image;

    public Imgdata(){}

    public Imgdata(String imgname, String bigcategory, String middlecategory, String furniturename, String style, String selectfd, int price, int color, String detail, String image) {
        this.imgname = imgname;
        this.bigcategory = bigcategory;
        this.middlecategory = middlecategory;
        this.furniturename = furniturename;
        this.style = style;
        this.selectfd = selectfd;
        this.price = price;
        this.color = color;
        this.detail = detail;
        this.image = image;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getBigcategory() {
        return bigcategory;
    }

    public void setBigcategory(String bigcategory) {
        this.bigcategory = bigcategory;
    }

    public String getMiddlecategory() {
        return middlecategory;
    }

    public void setMiddlecategory(String middlecategory) {
        this.middlecategory = middlecategory;
    }

    public String getFurniturename() {
        return furniturename;
    }

    public void setFurniturename(String furniturename) {
        this.furniturename = furniturename;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSelectfd() {
        return selectfd;
    }

    public void setSelectfd(String selectfd) {
        this.selectfd = selectfd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
