/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.database.sql;

import com.se.database.entities.Grn;
import static com.se.database.sql.GrnSQL.c;
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
public class GrnSQL {
    
    public static final Connect c = new Connect();
    
    public static final int addGRN(int grn_id, double net_total, String made_date, String note, int supplier_sup_id, int employee_emp_id) {

        String query = "INSERT INTO grn (grn_id,net_total,made_date,special_notes,supplier_sup_id,employee_emp_id) VALUES ("
                + "'" + grn_id + "',"
                + "'" + net_total + "',"
                + "'" + made_date + "',"
                + "'" + note + "',"
                + "'" + supplier_sup_id + "',"
                + "'" + employee_emp_id + "'"
                + ")";
        return c.setQuery(query, "");
    }
    
    public static final List<Grn> getAllItems() {

        List<Grn> gItems = new ArrayList<>();

        String query = "SELECT grn_id,net_total,made_date,special_notes,supplier_sup_id,employee_emp_id FROM grn ORDER BY made_date DESC";

        ResultSet rset = c.getQuery(query);

        try {
            c.conn().close();
            System.out.println("Connection closed");
            while (rset.next()) {
                int grn_id = rset.getInt("grn_id");
                double net_total = rset.getDouble("net_total");
                String made_date= rset.getString("made_date");
                String notes = rset.getString("special_notes");
                int supplier_sup_id = rset.getInt("supplier_sup_id");
                int employee_emp_id = rset.getInt("employee_emp_id");
                Grn temp = new Grn(grn_id,net_total,made_date,notes,supplier_sup_id,employee_emp_id);
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
