/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.entities;

/**
 *
 * @author BHARATHA
 */
public class Supplier {
    private int sup_id;
    private String title;
    private String name;
    private String nic;
    private String company;
    private String email;
    private String phone;
   

    public Supplier(int sup_id, String title, String name, String nic, String company, String email, String phone) {
        this.sup_id = sup_id;
        this.title = title;
        this.name = name;
        this.nic = nic;
        this.company = company;
        this.email = email;
        this.phone = phone;
        
    }

    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }

    public int getSup_id() {
        return sup_id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getNic() {
        return nic;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getphone() {
        return phone;
    }

}
