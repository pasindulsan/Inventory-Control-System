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
public class Grn {
    private int grn_id;	
    private double net_total;	
    private String made_date;
    private String note;
    private int supplier_sup_id;	
    private int employee_emp_id;

    public Grn(int grn_id, double net_total, String made_date, int supplier_sup_id, int employee_emp_id) {
        this.grn_id = grn_id;
        this.net_total = net_total;
        this.made_date = made_date;
        this.supplier_sup_id = supplier_sup_id;
        this.employee_emp_id = employee_emp_id;
    }
    
    public Grn(int grn_id, double net_total, String made_date, String note, int supplier_sup_id, int employee_emp_id) {
        this.grn_id = grn_id;
        this.net_total = net_total;
        this.made_date = made_date;
        this.note = note;
        this.supplier_sup_id = supplier_sup_id;
        this.employee_emp_id = employee_emp_id;
    }

    public Grn(int grn_id) {
        this.grn_id = grn_id;
    }

    public int getGrn_id() {
        return grn_id;
    }

    public double getNet_total() {
        return net_total;
    }

    public String getMade_date() {
        return made_date;
    }

    public int getSupplier_sup_id() {
        return supplier_sup_id;
    }

    public int getEmployee_emp_id() {
        return employee_emp_id;
    }

    public String getNote() {
        return note;
    }
    
    
}
