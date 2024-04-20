/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BHARATHA
 */
public class Connect {

    private Connection a;
    private String url = "jdbc:mysql://localhost:";
    private String port = "3306";
    private String db = "se_db";
    private String uName = "root";
    private String password = "rootroot";

    // create connection
    public Connection conn() {
        a = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            a = DriverManager.getConnection(url + port + "/" + db, uName, password);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    // get values
    public ResultSet getQuery(String query) {
        ResultSet r = null;
        a = conn();
        try {
            Statement s = conn().createStatement();
            r = s.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }
        return r;
    }

    // insert
    public int setQuery(String query, String column_name) {
        int i = 0;
        a = conn();
        try {
            Statement stmt = conn().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet r = stmt.getGeneratedKeys();

            while (r.next()) {
                i = r.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        } finally {
            try {
                a.close();
                System.gc();
                System.out.println("Connection closed");
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
                System.out.println(ex);
            }
        }
        return i;
    }

    // delete & update
    public boolean setQuery(String query) {
        a = conn();
        try {
            Statement stmt = conn().createStatement();
            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
            return false;
        } finally {
            try {
                a.close();
                System.gc();
                System.out.println("Connection closed");
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
                System.out.println(ex);
            }
        }
    }
}
