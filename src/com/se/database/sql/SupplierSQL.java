/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.sql;

import com.se.database.entities.Supplier;
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
public class SupplierSQL {
    public static final Connect c = new Connect();
    
    public static List<Supplier> getAllSuppliers() {
        List<Supplier> sup = new ArrayList();
        String query = "SELECT sup_id, sup_title, sup_name, nic, company, email, phone FROM supplier";
        ResultSet rset = c.getQuery(query);
        try {
            c.conn().close();
            System.out.println("Connection closed");
            while (rset.next()) {
                int sup_id = rset.getInt("sup_id");
                String title = rset.getString("sup_title");
                String name = rset.getString("sup_name");
                String nic = rset.getString("nic");
                String company = rset.getString("company");
                String email = rset.getString("email");
                String phone = rset.getString("phone");
               

                Supplier temp = new Supplier(sup_id, title, name, nic, company, email, phone);
                sup.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierSQL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                rset.close();
            } catch (SQLException ex) {
                Logger.getLogger(SupplierSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.gc();
        return sup;
    }
    
    // grn eke wenas supplierslawa select karanna
    public static List<String> getSuppliers() {
        List<String> categories = new ArrayList<>();

        String query = "SELECT DISTINCT company FROM supplier ORDER BY company";

        ResultSet rset = c.getQuery(query);
        try {

            c.conn().close();
            System.out.println("Connection closed");

            try {
                while (rset.next()) {
                    categories.add(rset.getString("company"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                rset.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.gc();
        return categories;
    }
    
    public static final int addSupplier(int id, String title, String name, String company, String nic, String email, String phone) {
        String query = "INSERT INTO supplier (sup_id, sup_title, sup_name, company, nic, email, phone) VALUES ("
                + "'" + id + "',"
                + "'" + title + "',"
                + "'" + name + "',"
                + "'" + company + "',"
                + "'" + nic + "',"
                + "'" + email + "',"
                + "'" + phone + "'"
                + ")";
        return c.setQuery(query, "");
    }
    
    public static final void updateSupplier(int id, String name, String company, String nic, String email, String phone) {
        String query = "UPDATE supplier SET sup_name = '" + name + "', company = '" + company + "', nic = '" + nic + "', email = '" + email + "', phone = '" + phone + "' WHERE sup_id = '" + id + "'";
        c.setQuery(query);
    }
    
    
    // grn eke supplier foreign key eka set karanna supplier id eka gannawa company name eken
    public static final int getSupplierID(String company){
    String query = "SELECT sup_id FROM supplier WHERE company='"+company+"'";
    int sid=0;
    ResultSet rset = c.getQuery(query);
        try {

            c.conn().close();
            System.out.println("Connection closed");

            try {
                while (rset.next()) {
                    sid= rset.getInt("sup_id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                rset.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.gc();
        return sid;
    }
    
}
