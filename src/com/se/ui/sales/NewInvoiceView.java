/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ui.sales;

import com.se.database.entities.Items;
import com.se.database.sql.ItemSQL;
import com.se.database.sql.TransactionHasItemSQL;
import com.se.database.sql.TransactionSQL;
import com.se.ui.utils.Report;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.type.OrientationEnum;

/**
 *
 * @author Gayani
 */
public class NewInvoiceView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ItemListView
     */
    public NewInvoiceView() {
        initComponents();
    }

    private DefaultTableModel dtmItems;
    private DefaultTableModel dtmCart;
    private List<Items> list;
    private ArrayList<Object> items;
    private int qty;
    private double total;
    private int id;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblItem = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cmbCategory = new javax.swing.JComboBox<>();
        lblCategory = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemList = new javax.swing.JTable();
        spinnerQty = new javax.swing.JSpinner();
        lblQty = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        pannelCart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTQnty = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setClosable(true);
        setTitle("New Invoice");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblItem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblItem.setText("Item");
        jPanel1.add(lblItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 33, 20));

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, 23));

        cmbCategory.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select the Category>" }));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 240, -1));

        lblCategory.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblCategory.setText("Category");
        jPanel1.add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        tblItemList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblItemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Unit Price", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItemList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblItemList);
        if (tblItemList.getColumnModel().getColumnCount() > 0) {
            tblItemList.getColumnModel().getColumn(1).setMinWidth(0);
            tblItemList.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblItemList.getColumnModel().getColumn(1).setMaxWidth(90);
            tblItemList.getColumnModel().getColumn(2).setMinWidth(0);
            tblItemList.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblItemList.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 350, 140));

        spinnerQty.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        spinnerQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerQtyStateChanged(evt);
            }
        });
        jPanel1.add(spinnerQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 50, -1));

        lblQty.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblQty.setText("Qty");
        jPanel1.add(lblQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 30, 20));

        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 140, -1));

        pannelCart.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 120, 212)), "Cart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Item", "Unit Price (Rs)", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setMinWidth(0);
            tblCart.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblCart.getColumnModel().getColumn(0).setMaxWidth(200);
            tblCart.getColumnModel().getColumn(2).setMinWidth(0);
            tblCart.getColumnModel().getColumn(2).setPreferredWidth(160);
            tblCart.getColumnModel().getColumn(2).setMaxWidth(160);
            tblCart.getColumnModel().getColumn(3).setMinWidth(0);
            tblCart.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblCart.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        btnClear.setText("Clear All");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Total Quantity");

        lblTQnty.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTQnty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTQnty.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Sub Total");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Rs. 0.0");

        javax.swing.GroupLayout pannelCartLayout = new javax.swing.GroupLayout(pannelCart);
        pannelCart.setLayout(pannelCartLayout);
        pannelCartLayout.setHorizontalGroup(
            pannelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelCartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(pannelCartLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lblTQnty, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelCartLayout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        pannelCartLayout.setVerticalGroup(
            pannelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelCartLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pannelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnRemove)
                    .addComponent(btnCheckout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTQnty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pannelCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 700, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        setDtmItems();
        resetTxt();
        cmbCategoryAction(cmbCategory.getSelectedIndex());
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        tblItemAction();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void spinnerQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerQtyStateChanged
        if ((int) spinnerQty.getValue() < 0) {
            spinnerQty.setValue(0);
        }
    }//GEN-LAST:event_spinnerQtyStateChanged

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        if (tblCart.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cart is already empty!", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int input = JOptionPane.showConfirmDialog(this, "Do you want to clear the cart?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == JOptionPane.YES_OPTION) {
                setDtmCart();
                items.clear();
                qty = 0;
                total = 0.0d;
                lblTQnty.setText("0");
                lblTotal.setText("Rs. 0.00");
            }
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        this.setDtmItems();
        if (cmbCategory.getSelectedIndex() == 0) {
            list.forEach(item -> {
                if (item.getItem_Name().toLowerCase().contains(txtId.getText().toLowerCase(Locale.ITALY))) {
                    dtmItems.addRow(new Object[]{item.getItem_Name(), String.format("%.2f", item.getUnit_price()), item.getNet_qty()});
                }
            });
        } else {
            list.forEach(item -> {
                if (item.getItem_Name().contains(txtId.getText()) && item.getCategory().equals(cmbCategory.getSelectedItem().toString())) {
                    dtmItems.addRow(new Object[]{item.getItem_Name(), String.format("%.2f", item.getUnit_price()), item.getNet_qty()});
                }
            });
        }
        if (tblItemList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No items found");
            resetTxt();
            cmbCategoryAction(cmbCategory.getSelectedIndex());
        }
    }//GEN-LAST:event_txtIdKeyReleased

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        removeFromCart();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        if (tblCart.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No items in the cart");
        } else {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            int transId = TransactionSQL.addTransaction(0, qty, total, sdf.format(d), id);
            int item_id = 0;
            int net_qty = 0;
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                for (Items item : list) {
                    if (item.getItem_Name().equals(tblCart.getValueAt(i, 1))) {
                        item_id = item.getItem_id();
                        net_qty = item.getNet_qty();
                    }
                }
                TransactionHasItemSQL.addTransactionItem(transId, item_id, Integer.parseInt(tblCart.getValueAt(i, 3).toString()));
                ItemSQL.setQty(item_id, net_qty - Integer.parseInt(tblCart.getValueAt(i, 3).toString()));
            }
            //JOptionPane.showMessageDialog(this, "List wass added successfully");
            Report r = new Report();
        r.generateReport("Invoice.jrxml", null, OrientationEnum.PORTRAIT);
            initializeView(id);
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblTQnty;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pannelCart;
    private javax.swing.JSpinner spinnerQty;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblItemList;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    public void initializeView(int id) {
        list = ItemSQL.getAllItems();
        setDtmItems();
        setDtmCart();
        resetTxt();
        this.id = id;
        cmbCategory.removeAllItems();
        cmbCategory.addItem("<All categories>");

        List<String> groups = ItemSQL.getCategory();
        groups.forEach(group -> {
            cmbCategory.addItem(group);
        });
        items = new ArrayList<>();
        qty = 0;
        total = 0.0d;
        lblTQnty.setText("0");
        lblTotal.setText("Rs. 0.00");
    }

    private void setDtmItems() {
        dtmItems = (DefaultTableModel) this.tblItemList.getModel();
        dtmItems.getDataVector().removeAllElements();
        dtmItems.fireTableDataChanged();
    }

    private void setDtmCart() {
        dtmCart = (DefaultTableModel) this.tblCart.getModel();
        dtmCart.getDataVector().removeAllElements();
        dtmCart.fireTableDataChanged();
    }

    private void resetTxt() {
        txtId.setText("");
    }

    private void cmbCategoryAction(int category) {
        switch (category) {
            case -1:
                break;
            case 0:
                list.forEach(item -> {
                    dtmItems.addRow(new Object[]{item.getItem_Name(), String.format("%.2f", item.getUnit_price()), item.getNet_qty()});
                });
                break;

            default:
                list.forEach(item -> {
                    if (item.getCategory().equals(cmbCategory.getSelectedItem().toString())) {
                        dtmItems.addRow(new Object[]{item.getItem_Name(), String.format("%.2f", item.getUnit_price()), item.getNet_qty()});
                    }
                });
                break;
        }
    }

    private void cmbCartAction(int category) {
        switch (category) {
            case -1:
                break;
            case 0:
                list.forEach(item -> {
                    if (item.getItem_Name().equals(tblItemList.getValueAt(tblItemList.getSelectedRow(), 0))) {
                        dtmCart.addRow(new Object[]{item.getCategory(), item.getItem_Name(), String.format("%.2f", item.getUnit_price()), spinnerQty.getValue().toString()});
                    }

                });
                break;

            default:
                list.forEach(item -> {
                    if (item.getItem_Name().equals(tblItemList.getValueAt(tblItemList.getSelectedRow(), 0)) && item.getCategory().equals(cmbCategory.getSelectedItem().toString())) {
                        dtmCart.addRow(new Object[]{item.getCategory(), item.getItem_Name(), String.format("%.2f", item.getUnit_price()), spinnerQty.getValue().toString()});
                    }
                });
                break;
        }
    }

    private void calQty() {
        qty += Integer.parseInt(spinnerQty.getValue().toString());
        lblTQnty.setText(String.valueOf(qty));
    }

    private void calTotal() {
        total += (Double) ((Integer.parseInt(spinnerQty.getValue().toString())) * (Double.parseDouble(tblItemList.getValueAt(tblItemList.getSelectedRow(), 1).toString())));
        lblTotal.setText(String.valueOf("Rs. " + total));
    }

    private void subQty() {
        qty -= Integer.parseInt(tblCart.getValueAt(tblCart.getSelectedRow(), 3).toString());
        lblTQnty.setText(String.valueOf(qty));
    }

    private void subTotal() {
        total -= (Double) ((Integer.parseInt(tblCart.getValueAt(tblCart.getSelectedRow(), 3).toString())) * (Double.parseDouble(tblCart.getValueAt(tblCart.getSelectedRow(), 2).toString())));
        lblTotal.setText(String.valueOf("Rs. " + total));
    }

    private void tblItemAction() {
        int row = tblItemList.getSelectedRow();
        if (row != -1) {
            
            if ((int) this.spinnerQty.getValue() == 0) {

                JOptionPane.showMessageDialog(this, "Select the quantity", "", JOptionPane.ERROR_MESSAGE);
            } else if (items.contains(tblItemList.getValueAt(row, 0).toString())) {
                JOptionPane.showMessageDialog(this, "Item is already excist");
            } else if ((int) tblItemList.getValueAt(row, 2) >= (int) this.spinnerQty.getValue()) {
                
                cmbCartAction(cmbCategory.getSelectedIndex());
                items.add(tblItemList.getValueAt(row, 0));
                
                calQty();
                calTotal();
            } else {
                JOptionPane.showMessageDialog(this, "Not enough items to add", "", JOptionPane.ERROR_MESSAGE);
            }
           
        } else {
            
            JOptionPane.showMessageDialog(this, "Seletc item to add to cart", "", JOptionPane.ERROR_MESSAGE);
        }
        spinnerQty.setValue(0);
    }

    private void removeFromCart() {
        int arr[] = tblCart.getSelectedRows();
        if (arr.length == 0) {
            JOptionPane.showMessageDialog(this, "Select an item to remove");

        } else if (arr.length > 1) {
            JOptionPane.showMessageDialog(this, "Select  one item at a time");
            tblCart.clearSelection();
        } else if (arr.length == 1) {
            subQty();
            subTotal();
            items.remove(tblCart.getValueAt(tblCart.getSelectedRow(), 1));
            dtmCart.removeRow(tblCart.getSelectedRow());
        }
    }

}
