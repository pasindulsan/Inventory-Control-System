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
public class Transaction {
    private int trans_id;
    private int net_qty;
    private double net_total;
    private String made_dateS;
    private int employee_emp_id;

    public Transaction(int trans_id,int net_qty, double net_total, String made_dateS,  int employee_emp_id) {
        this.trans_id = trans_id;
        this.net_qty = net_qty;
        this.net_total = net_total;
        this.made_dateS = made_dateS;
        this.employee_emp_id = employee_emp_id;
    }

    public Transaction(int trans_id) {
        this.trans_id = trans_id;
    }

    public int getTrans_id() {
        return trans_id;
    }

    public int getNet_qty() {
        return net_qty;
    }

    public double getNet_total() {
        return net_total;
    }

    public String getMade_dateS() {
        return made_dateS;
    }

    public int getEmployee_emp_id() {
        return employee_emp_id;
    }
    
    
    
    
    
    
    
    
    
}
