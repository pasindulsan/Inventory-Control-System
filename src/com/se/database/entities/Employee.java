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
public class Employee {

    private int emp_id;
    private String title;
    private String name;
    private String role;
    private String nic;
    private String email;
    private String phone;
    private String uname;
    private String password;
    private int logged_in;
    private String last_logged_in;
    private int availability;

    public Employee(int emp_id, String title, String name, String role, String nic, String email, String phone, String uname, String password, int logged_in, String last_logged_in, int availability) {
        this.emp_id = emp_id;
        this.title = title;
        this.name = name;
        this.role = role;
        this.nic = nic;
        this.email = email;
        this.phone = phone;
        this.uname = uname;
        this.password = password;
        this.logged_in = logged_in;
        this.last_logged_in = last_logged_in;
        this.availability = availability;
    }

    public Employee(int emp_id, String title, String name, String role, String nic, String email, String phone, String uname, int logged_in, String last_logged_in, int availability) {
        this.emp_id = emp_id;
        this.title = title;
        this.name = name;
        this.role = role;
        this.nic = nic;
        this.email = email;
        this.phone = phone;
        this.uname = uname;
        this.logged_in = logged_in;
        this.last_logged_in = last_logged_in;
        this.availability = availability;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getNic() {
        return nic;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }

    public int getLogged_in() {
        return logged_in;
    }

    public String getLast_logged_in() {
        return last_logged_in;
    }

    public int getAvailability() {
        return availability;
    }

}
