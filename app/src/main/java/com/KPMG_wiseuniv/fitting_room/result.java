package com.KPMG_wiseuniv.fitting_room;

//class for AI result from server

public class result {
    int interior;//interior style from AI result
    int color;//suitable color from AI result
    int FD;//furniture detail from AI result
    public result(){}

    public result(int interior, int color, int FD) {
        this.interior = interior;
        this.color = color;
        this.FD = FD;
    }

    public int getInterior() {
        return interior;
    }

    public void setInterior(int interior) {
        this.interior = interior;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFD() {
        return FD;
    }

    public void setFD(int FD) {
        this.FD = FD;
    }
}
