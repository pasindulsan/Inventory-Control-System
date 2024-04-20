/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.sql;

import com.se.database.entities.Transaction;
import com.se.database.utils.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TransactionSQL {

    public static final Connect c = new Connect();

    public static final int addTransaction(int trans_id,int net_qty, double net_total, String made_dateS, int employee_emp_id) {

        String query = "INSERT INTO transaction (trans_id,net_qty,net_total,made_date,employee_emp_id) VALUES ("
                + "'" + trans_id + "',"
                + "'" + net_qty + "',"
                + "'" + net_total + "',"
                + "'" + made_dateS + "',"
                + "'" + employee_emp_id + "'"
                + ")";
        return c.setQuery(query, "");
    }
    
    public static final List<Transaction> getAllItems() {

        List<Transaction> tItems = new ArrayList<>();

        String query = "SELECT trans_id,net_qty,net_total,made_date,employee_emp_id FROM transaction ORDER BY made_date DESC";

        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            while (rset.next()) {
                int trans_id = rset.getInt("trans_id");
                int net_qty = rset.getInt("net_qty");
                double net_total= rset.getDouble("net_total");
                String made_date = rset.getString("made_date");
                int employee_emp_id = rset.getInt("employee_emp_id");
                Transaction temp = new Transaction(trans_id, net_qty, net_total, made_date, employee_emp_id);
                tItems.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rset.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.gc();
        return tItems;
    }
    
     
}
