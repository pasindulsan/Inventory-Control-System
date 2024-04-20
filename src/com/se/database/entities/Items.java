/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.entities;

/**
 *
 * @author Gayani
 */
public class Items {
    private int item_id;
    private String category;
    private String item_name;
    private double unit_price;
    private int net_qty;
    private String warranty;

    public Items(int item_id, String category, String item_name,double unit_price, int net_qty,String warranty) {
        this.item_id=item_id;
        this.category=category;
        this.item_name=item_name;
        this.unit_price = unit_price;
        this.net_qty=net_qty;
        this.warranty=warranty;
        
    }
    
    public int getItem_id() {
        return item_id;
    }

    public String getCategory() {
        return category;
    }

    public String getItem_Name() {
        return item_name;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public int getNet_qty() {
        return net_qty;
    }

    public String getWarranty() {
        return warranty;
    }

}
