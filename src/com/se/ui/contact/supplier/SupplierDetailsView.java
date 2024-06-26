package com.se.ui.contact.supplier;

import com.se.database.entities.Employee;
import com.se.database.entities.Supplier;
import com.se.database.sql.SupplierSQL;
import com.se.ui.dashboard.DashboardView;
import static com.se.ui.dashboard.DashboardView.DesktopPane;
import java.awt.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RDA
 */
public class SupplierDetailsView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewSupplierUpdate
     */
    public SupplierDetailsView() {
        initComponents();
    }

    private Employee aEmp;
    private String role;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        ViewSupplierUpdate = new javax.swing.JPanel();
        lblSupID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        lblNic = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelephone = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        lblNameView = new javax.swing.JLabel();
        lblCompanyView = new javax.swing.JLabel();
        lblEmailView = new javax.swing.JLabel();
        lblPhoneView = new javax.swing.JLabel();
        lblSupIDView = new javax.swing.JLabel();
        lblNicView = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblTitleView = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setClosable(true);
        setTitle("Supplier Details");

        lblSupID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblSupID.setText("Supplier ID");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblName.setText("Name");

        lblCompany.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblCompany.setText("Company");

        lblNic.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblNic.setText("NIC");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblEmail.setText("E-mail");

        lblTelephone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblTelephone.setText("Telephone");

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblNameView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblCompanyView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblEmailView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblPhoneView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblSupIDView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblNicView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblTitle.setText("Title");

        lblTitleView.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout ViewSupplierUpdateLayout = new javax.swing.GroupLayout(ViewSupplierUpdate);
        ViewSupplierUpdate.setLayout(ViewSupplierUpdateLayout);
        ViewSupplierUpdateLayout.setHorizontalGroup(
            ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSupplierUpdateLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewSupplierUpdateLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(ViewSupplierUpdateLayout.createSequentialGroup()
                        .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewSupplierUpdateLayout.createSequentialGroup()
                                .addComponent(lblSupID)
                                .addGap(91, 91, 91)
                                .addComponent(lblSupIDView, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ViewSupplierUpdateLayout.createSequentialGroup()
                                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblCompany)
                                    .addComponent(lblNic)
                                    .addComponent(lblEmail)
                                    .addComponent(lblTelephone)
                                    .addComponent(lblTitle))
                                .addGap(91, 91, 91)
                                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNameView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCompanyView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEmailView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPhoneView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                    .addComponent(lblNicView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTitleView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        ViewSupplierUpdateLayout.setVerticalGroup(
            ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSupplierUpdateLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupID)
                    .addComponent(lblSupIDView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitleView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompany)
                    .addComponent(lblCompanyView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNic)
                    .addComponent(lblNicView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblEmailView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelephone)
                    .addComponent(lblPhoneView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewSupplierUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewSupplierUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewSupplierUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        EditSupplierView view = new EditSupplierView();
        DashboardView.DesktopPane.remove((Component) view);
        DashboardView.DesktopPane.add((Component) view);
        view.initializeView(aEmp, Integer.parseInt(lblSupIDView.getText()), lblTitleView.getText(), lblNameView.getText(), lblCompanyView.getText(), lblNicView.getText(), lblEmailView.getText(), lblPhoneView.getText());
        view.setLocation((int) ((DesktopPane.getSize().width - view.getSize().width) / 2), (int) ((DesktopPane.getSize().height - view.getSize().height) / 2));
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        SupplierView view = new SupplierView();
        this.dispose();
        DashboardView.DesktopPane.remove((Component) view);
        DashboardView.DesktopPane.add((Component) view);
        view.initializeView(aEmp);
        view.setLocation((int) ((DesktopPane.getSize().width - view.getSize().width) / 2), (int) ((DesktopPane.getSize().height - view.getSize().height) / 2));
        view.setVisible(true);
    }//GEN-LAST:event_btnOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ViewSupplierUpdate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblCompanyView;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailView;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameView;
    private javax.swing.JLabel lblNic;
    private javax.swing.JLabel lblNicView;
    private javax.swing.JLabel lblPhoneView;
    private javax.swing.JLabel lblSupID;
    private javax.swing.JLabel lblSupIDView;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleView;
    // End of variables declaration//GEN-END:variables

    void initializeView(Employee aEmp, Supplier sup) {
        this.aEmp = aEmp;
        this.role = aEmp.getRole();
        if (role.equals("Admin")) {
            btnEdit.setVisible(true);
        } else {
            btnEdit.setVisible(false);
        }
        lblSupIDView.setText(String.valueOf(sup.getSup_id()));
        lblTitleView.setText(sup.getTitle());
        lblNameView.setText(sup.getName());
        lblCompanyView.setText(sup.getCompany());
        lblNicView.setText(sup.getNic());
        lblEmailView.setText(sup.getEmail());
        lblPhoneView.setText(sup.getphone());
    }
}
