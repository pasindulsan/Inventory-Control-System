/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ui.stock;

import com.se.ui.dashboard.DashboardView;
import static com.se.ui.dashboard.DashboardView.DesktopPane;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHARATHA
 */
public class ItemSelectorView extends javax.swing.JInternalFrame {

    public final ManageItemListView view = new ManageItemListView();
    /**
     * Creates new form SelectorView
     */
    public ItemSelectorView() {
        initComponents();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExisting = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();

        setClosable(true);

        btnExisting.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExisting.setText("Existing");
        btnExisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExistingActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExisting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(btnExisting)
                .addGap(46, 46, 46)
                .addComponent(btnNew)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        AddNewItemView view = new AddNewItemView();
        DashboardView.DesktopPane.remove((Component) view);
        DashboardView.DesktopPane.add((Component) view);
        view.initializeView();
        view.setLocation((int) ((DesktopPane.getSize().width - view.getSize().width) / 2), (int) ((DesktopPane.getSize().height - view.getSize().height) / 2));
        //this.dispose();
        view.setVisible(true);
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExistingActionPerformed
        DashboardView.DesktopPane.remove((Component) view);
        DashboardView.DesktopPane.add((Component) view);
        try {
            view.initializeView();
        } catch (SQLException ex) {
            Logger.getLogger(ItemSelectorView.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setLocation((int) ((DesktopPane.getSize().width - view.getSize().width) / 2), (int) ((DesktopPane.getSize().height - view.getSize().height) / 2));
        view.setVisible(true);
    }//GEN-LAST:event_btnExistingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExisting;
    private javax.swing.JButton btnNew;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void initializeView(String role) {
        if (!role.equals("Admin")) {
            btnNew.setVisible(false);
        }
    }
}