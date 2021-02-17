package com.KPMG_wiseuniv.fitting_room;

import java.util.ArrayList;

public class ManageImgdata {
    private static ManageImgdata manageImgdata=null;
    Imgdata imgdata;
    ArrayList<Imgdata> total_imgdata;
    public static ManageImgdata getInstance(){
        if(manageImgdata==null){
            manageImgdata=new ManageImgdata();
        }
        return manageImgdata;
    }
    private ManageImgdata(){
        imgdata=new Imgdata();
        total_imgdata=new ArrayList<>();
    }

    public void setImgdata(Imgdata imgdata) {
        this.imgdata = imgdata;
    }

    public Imgdata getImgdata() {
        return imgdata;
    }

    public void setTotal_imgdata(ArrayList<Imgdata> total_imgdata) {
        this.total_imgdata = total_imgdata;
    }

    public ArrayList<Imgdata> getTotal_imgdata() {
        return total_imgdata;
    }
}
