/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.entities;

/**
 *
 * @author KG
 */
public class GrnHasItem {
    private int grn_grn_id;	
    private int item_item_id;	
    private int item_qty;

    public GrnHasItem(int grn_grn_id, int item_item_id, int item_qty) {
        this.grn_grn_id = grn_grn_id;
        this.item_item_id = item_item_id;
        this.item_qty = item_qty;
    }

    public int getGrn_grn_id() {
        return grn_grn_id;
    }

    public int getItem_item_id() {
        return item_item_id;
    }

    public int getItem_qty() {
        return item_qty;
    }
    
    

}
