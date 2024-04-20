 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.sql;

import com.se.database.entities.Items;
import com.se.database.utils.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gayani
 */
public class ItemSQL {

    public static final Connect c = new Connect();

    public static List<String> getCategory() {
        List<String> categories = new ArrayList<>();

        String query = "SELECT DISTINCT category FROM item ORDER BY category";

        ResultSet rset = c.getQuery(query);
        try {

            c.conn().close();
            System.out.println("Connection closed");

            try {
                while (rset.next()) {
                    categories.add(rset.getString("category"));
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

    public static final List<Items> getAllItems() {

        List<Items> items = new ArrayList<>();

        String query = "SELECT item_id,category,item_name,unit_price,net_qty,warranty FROM item WHERE net_qty>0 ORDER BY item_name";

        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            while (rset.next()) {
                int item_id = rset.getInt("item_id");
                String category = rset.getString("category");
                String item_name = rset.getString("item_name");
                int net_qty = rset.getInt("net_qty");
                double unit_price = rset.getDouble("unit_price");
                String warranty = rset.getString("warranty");
                Items temp = new Items(item_id, category, item_name, unit_price, net_qty, warranty);
                items.add(temp);
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
        return items;
    }

    
    public static final void setQty(int id, int qty) {
        String query = "UPDATE item SET net_qty = '" + qty + "' WHERE item_id = '" + id + "'";
        c.setQuery(query);
    }
    
    public static final void updateItem(int id, String category, String name, int qty, double price, String warranty) {

        try {
            String query = "UPDATE item SET "
                    + "category = '" + category + "',"
                    + "item_name = '" + name + "',"
                    + "net_qty = '" + qty + "',"
                    + "unit_price = '" + price + "',"
                    + "warranty = '" + warranty + "'"
                    + "WHERE item_id = '" + id + "'";
            c.setQuery(query);
            c.conn().close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            Logger.getLogger(ItemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.gc();
    }

    public static final int addItem(int id, String category, String name, int qty, double price, String warranty) {
        String query = "INSERT INTO item (item_id,category,item_name,net_qty,unit_price,warranty) VALUES ("
                + "'" + id + "',"
                + "'" + category + "',"
                + "'" + name + "',"
                + "'" + qty + "',"
                + "'" + price + "',"
                + "'" + warranty + "'"
                + ")";
        return c.setQuery(query, "");
    }
}
 