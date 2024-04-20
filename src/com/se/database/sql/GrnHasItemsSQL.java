/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.sql;

import com.se.database.entities.GrnHasItem;
import static com.se.database.sql.GrnHasItemsSQL.c;
import com.se.database.utils.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KG
 */
public class GrnHasItemsSQL {
     public static final Connect c = new Connect();
     
     public static final void addGrnItem(int grn_grn_id, int item_item_id, int item_qty) {

        String query = "INSERT INTO grn_has_item (grn_grn_id,item_item_id,item_qty) VALUES ("
                + "'" + grn_grn_id + "',"
                + "'" + item_item_id + "',"
                + "'" + item_qty + "'"
                + ")";
        c.setQuery(query);
    }
     
     public static final List<GrnHasItem> getAllItems() {

        List<GrnHasItem> gItems = new ArrayList<>();

        String query = "SELECT grn_grn_id,item_item_id,item_qty FROM grn_has_item ";

        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            while (rset.next()) {
                int grn_grn_id = rset.getInt("grn_grn_id");
                int item_item_id = rset.getInt("item_item_id");
                int item_qty= rset.getInt("item_qty");
                GrnHasItem temp = new GrnHasItem(grn_grn_id, item_item_id, item_qty);
                gItems.add(temp);
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
        return gItems;
    }
}
