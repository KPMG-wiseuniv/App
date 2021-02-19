package com.KPMG_wiseuniv.fitting_room;

public class result {
    int interior;
    int color;
    int FD;
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
