/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.entities;

/**
 *
 * @author User
 */
public class TransactionHasItem {

    private int transaction_trans_id;
    private int item_item_id;
    private int item_qty;

    public TransactionHasItem(int transaction_trans_id, int item_item_id, int item_qty) {
        this.transaction_trans_id = transaction_trans_id;
        this.item_item_id = item_item_id;
        this.item_qty = item_qty;
    }

    public int getTransaction_trans_id() {
        return transaction_trans_id;
    }

    public int getItem_item_id() {
        return item_item_id;
    }

    public int getItem_qty() {
        return item_qty;
    }
    
    

}
