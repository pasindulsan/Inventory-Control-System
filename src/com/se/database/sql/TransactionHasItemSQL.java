/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.sql;

import com.se.database.entities.Transaction;
import com.se.database.entities.TransactionHasItem;
import static com.se.database.sql.TransactionSQL.c;
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
public class TransactionHasItemSQL {

    public static final Connect c = new Connect();

    public static final void addTransactionItem(int transaction_trans_id, int item_item_id, int item_qty) {

        String query = "INSERT INTO transaction_has_item (transaction_trans_id,item_item_id,item_qty) VALUES ("
                + "'" + transaction_trans_id + "',"
                + "'" + item_item_id + "',"
                + "'" + item_qty + "'"
                + ")";
        c.setQuery(query);
        
        
    }
    
    
    public static final List<TransactionHasItem> getAllItems() {

        List<TransactionHasItem> tItems = new ArrayList<>();

        String query = "SELECT transaction_trans_id,item_item_id,item_qty FROM transaction_has_item ";

        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            while (rset.next()) {
                int transaction_trans_id = rset.getInt("transaction_trans_id");
                int item_item_id = rset.getInt("item_item_id");
                int item_qty= rset.getInt("item_qty");
                TransactionHasItem temp = new TransactionHasItem(transaction_trans_id, item_item_id, item_qty);
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
