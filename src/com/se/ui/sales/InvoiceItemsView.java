/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ui.sales;
import com.se.database.entities.Items;
import com.se.database.entities.TransactionHasItem;
import com.se.database.sql.ItemSQL;
import java.util.List;
import com.se.database.sql.TransactionHasItemSQL;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BHARATHA
 */


public class InvoiceItemsView extends javax.swing.JInternalFrame {

    int transID;
    String emp;
    String date;
    String total;
    
    private DefaultTableModel dtmTrans;
    private List<TransactionHasItem> list;
    private List<Items> Itmlist;
    
    public InvoiceItemsView() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoice = new javax.swing.JTable();
        lblInvoiceId = new javax.swing.JLabel();
        lblInvoiceIdShow = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblDateShow = new javax.swing.JLabel();
        lblEmployer = new javax.swing.JLabel();
        lblEmployerShow = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTotalView = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Invoice");

        tblInvoice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Item", "Qty", "Unit Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInvoice.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblInvoice);
        if (tblInvoice.getColumnModel().getColumnCount() > 0) {
            tblInvoice.getColumnModel().getColumn(0).setMinWidth(0);
            tblInvoice.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblInvoice.getColumnModel().getColumn(0).setMaxWidth(200);
            tblInvoice.getColumnModel().getColumn(2).setMinWidth(0);
            tblInvoice.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblInvoice.getColumnModel().getColumn(2).setMaxWidth(80);
            tblInvoice.getColumnModel().getColumn(3).setMinWidth(0);
            tblInvoice.getColumnModel().getColumn(3).setPreferredWidth(160);
            tblInvoice.getColumnModel().getColumn(3).setMaxWidth(160);
            tblInvoice.getColumnModel().getColumn(4).setMinWidth(0);
            tblInvoice.getColumnModel().getColumn(4).setPreferredWidth(160);
            tblInvoice.getColumnModel().getColumn(4).setMaxWidth(160);
        }

        lblInvoiceId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblInvoiceId.setText("Transaction ID :");

        lblInvoiceIdShow.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDate.setText("Date :");

        lblDateShow.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblEmployer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblEmployer.setText("Employer :");

        lblEmployerShow.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText("Total");

        lblTotalView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalView, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInvoiceId)
                                .addGap(18, 18, 18)
                                .addComponent(lblInvoiceIdShow, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(lblDate)
                                .addGap(18, 18, 18)
                                .addComponent(lblDateShow, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEmployer)
                                .addGap(34, 34, 34)
                                .addComponent(lblEmployerShow, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblInvoiceId)
                        .addComponent(lblInvoiceIdShow, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDate)
                        .addComponent(lblDateShow, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEmployer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmployerShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotalView, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateShow;
    private javax.swing.JLabel lblEmployer;
    private javax.swing.JLabel lblEmployerShow;
    private javax.swing.JLabel lblInvoiceId;
    private javax.swing.JLabel lblInvoiceIdShow;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalView;
    private javax.swing.JTable tblInvoice;
    // End of variables declaration//GEN-END:variables

public void initializeView(int INtransID,String INempID,String dt,String tol){
    this.transID = INtransID;
    this.emp = INempID;
    this.date = dt;
    this.total = tol;
    this.lblInvoiceIdShow.setText(String.valueOf(transID) );
    this.lblEmployerShow.setText(emp);
    this.lblDateShow.setText(dt);
    this.lblTotalView.setText(tol);
    
           list = TransactionHasItemSQL.getAllItems();
           Itmlist = ItemSQL.getAllItems();
        setDtmTrans();
        list.forEach(item -> {
           if(transID==item.getTransaction_trans_id()){
               
           String ItemName = "";
           String catagory ="";
           double UPrice=0;
            for (Items itm : Itmlist) {
                if (itm.getItem_id() == item.getItem_item_id()) {
                    ItemName= itm.getItem_Name();
                    UPrice = itm.getUnit_price();
                    catagory = itm.getCategory();
                }
            }
           double amount = UPrice*item.getItem_qty();
           dtmTrans.addRow(new Object[]{catagory, ItemName, item.getItem_qty(),String.format("%.2f", UPrice),String.format("%.2f", amount)});
           }
            
        });

}

 private void setDtmTrans() {
        dtmTrans = (DefaultTableModel) this.tblInvoice.getModel();
        dtmTrans.getDataVector().removeAllElements();
        dtmTrans.fireTableDataChanged();
    }


}

