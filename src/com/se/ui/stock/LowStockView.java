/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ui.stock;

import com.se.database.entities.Items;
import com.se.database.sql.ItemSQL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BHARATHA
 */
public class LowStockView extends javax.swing.JInternalFrame {

    /**
     * Creates new form LowStockView
     */
    public LowStockView() {
        initComponents();
        initializeView();
    }

    private DefaultTableModel dtmLS;
    private List<Items> list;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLS = new javax.swing.JTable();

        setClosable(true);
        setTitle("Low Stock");

        tblLS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Category", "QTY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLS.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblLS);
        if (tblLS.getColumnModel().getColumnCount() > 0) {
            tblLS.getColumnModel().getColumn(1).setMinWidth(0);
            tblLS.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblLS.getColumnModel().getColumn(1).setMaxWidth(200);
            tblLS.getColumnModel().getColumn(2).setMinWidth(0);
            tblLS.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblLS.getColumnModel().getColumn(2).setMaxWidth(90);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeView() {
        list = ItemSQL.getAllItems();
        setDtmLS();
        for (Items item : list) {
            if (item.getNet_qty() < 20) {
                dtmLS.addRow(new Object[]{item.getItem_Name(), item.getCategory(), item.getNet_qty()});
            }
        }
        if (tblLS.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No Items");
        }
    }
    
    private void setDtmLS() {
        dtmLS = (DefaultTableModel) this.tblLS.getModel();
        dtmLS.getDataVector().removeAllElements();
        dtmLS.fireTableDataChanged();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLS;
    // End of variables declaration//GEN-END:variables
}
