/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.sql;

import com.se.database.entities.Employee;
import com.se.database.utils.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHARATHA
 */
public class EmployeeSQL {

    public static final Connect c = new Connect();

    public static final List<Employee> getAllEmployee() {

        List<Employee> emp = new ArrayList<>();

        String query = "SELECT emp_id, title, name, role, nic, email, phone, uname, password, logged_in, last_logged_in, availability FROM employee";

        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            while (rset.next()) {
                int emp_id = rset.getInt("emp_id");
                String title = rset.getString("title");
                String name = rset.getString("name");
                String role = rset.getString("role");
                String nic = rset.getString("nic");
                String email = rset.getString("email");
                String phone = rset.getString("phone");
                String uname = rset.getString("uname");
                int logged_in = rset.getInt("logged_in");
                String last_logged_in = rset.getString("last_logged_in");
                int availability = rset.getInt("availability");

                Employee temp = new Employee(emp_id, title, name, role, nic, email, phone, uname, logged_in, last_logged_in, availability);
                emp.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rset.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.gc();
        return emp;
    }

    public static Employee getUser(String uName) {
        Employee emp = null;
        String query = "SELECT emp_id, title, name, role, nic, email, phone, uname, password, logged_in, last_logged_in, availability FROM employee WHERE uname = '" + uName + "' AND availability = '1'";
        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            if (rset.next()) {
                int emp_id = rset.getInt("emp_id");
                String title = rset.getString("title");
                String name = rset.getString("name");
                String role = rset.getString("role");
                String nic = rset.getString("nic");
                String email = rset.getString("email");
                String phone = rset.getString("phone");
                String uname = rset.getString("uname");
                String password = rset.getString("password");
                int logged_in = rset.getInt("logged_in");
                String last_logged_in = rset.getString("last_logged_in");
                int availability = rset.getInt("availability");

                emp = new Employee(emp_id, title, name, role, nic, email, phone, uname, password, logged_in, last_logged_in, availability);
            } else {
                emp = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rset.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emp;
    }

    public static Employee chk() {
        Employee emp = null;
        String query = "SELECT emp_id, title, name, role, nic, email, phone, uname, password, logged_in, last_logged_in, availability FROM employee WHERE logged_in != '0' AND availability = '1'";
        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            if (rset.next()) {
                int emp_id = rset.getInt("emp_id");
                String title = rset.getString("title");
                String name = rset.getString("name");
                String role = rset.getString("role");
                String nic = rset.getString("nic");
                String email = rset.getString("email");
                String phone = rset.getString("phone");
                String uname = rset.getString("uname");
                String password = rset.getString("password");
                int logged_in = rset.getInt("logged_in");
                String last_logged_in = rset.getString("last_logged_in");
                int availability = rset.getInt("availability");

                emp = new Employee(emp_id, title, name, role, nic, email, phone, uname, password, logged_in, last_logged_in, availability);
            } else {
                emp = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rset.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emp;
    }

    public static final void setLoggedIn(String uName, String date) {
        String query = "UPDATE employee SET last_logged_in = '" + date + "', logged_in = '1' WHERE employee.uname = '" + uName + "'";
        c.setQuery(query);
    }

    public static final void setLoggedOut(String uName) {
        String query = "UPDATE employee SET logged_in = '0' WHERE employee.name = '" + uName + "'";
        c.setQuery(query);
    }

    public static final int addEmployee(int id, String title, String name, String role, String nic, String email, String phone) {
        String query = "INSERT INTO employee (emp_id, title, name, role, nic, email, phone, uname, password, logged_in, last_logged_in, availability) VALUES ("
                + "'" + id + "',"
                + "'" + title + "',"
                + "'" + name + "',"
                + "'" + role + "',"
                + "'" + nic + "',"
                + "'" + email + "',"
                + "'" + phone + "',"
                + "'" + nic + "',"
                + "'" + "asdf1234" + "',"
                + "'" + "0" + "',"
                + "'" + "0000-00-00 00:00:00" + "',"
                + "'" + "1" + "'"
                + ")";
        return c.setQuery(query, "");
    }
    
    public static final void updateEmployee(int id, String name, String nic, String email, String phone) {
        String query = "UPDATE employee SET name = '" + name + "', nic = '" + nic + "', email = '" + email + "', phone = '" + phone + "' WHERE emp_id = '" + id + "'";
        c.setQuery(query);
    }
    
    public static final void updateUserName(int id, String uName) {
        String query = "UPDATE employee SET uname = '" + uName + "' WHERE emp_id = '" + id + "'";
        c.setQuery(query);
    }
    
    public static final void updateRole(int id, String role) {
        String query = "UPDATE employee SET role = '" + role + "' WHERE emp_id = '" + id + "'";
        c.setQuery(query);
    }
    
    public static final void updatePassword(int id, String password) {
        String query = "UPDATE employee SET password = '" + password + "' WHERE emp_id = '" + id + "'";
        c.setQuery(query);
    }
    
    public static final void removeEmployee(int id) {
        String query = "UPDATE employee SET availability = '0' WHERE employee.emp_id = '" + id + "'";
        c.setQuery(query);
    }
}
