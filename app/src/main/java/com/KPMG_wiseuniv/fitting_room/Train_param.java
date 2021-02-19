package com.KPMG_wiseuniv.fitting_room;

public class Train_param {
    String Furniture;
    String FD;

    public Train_param() {
    }

    public Train_param(String furniture, String FD) {
        Furniture = furniture;
        this.FD = FD;
    }

    public String getFurniture() {
        return Furniture;
    }

    public void setFurniture(String furniture) {
        Furniture = furniture;
    }

    public String getFD() {
        return FD;
    }

    public void setFD(String FD) {
        this.FD = FD;
    }
}
