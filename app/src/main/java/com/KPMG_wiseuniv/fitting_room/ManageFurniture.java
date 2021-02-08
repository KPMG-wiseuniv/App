package com.KPMG_wiseuniv.fitting_room;

import java.util.ArrayList;

public class ManageFurniture {
    private static ManageFurniture manageFurniture=null;
    Furniture furniture;
    ArrayList<Furniture> total_furniture;
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
}
