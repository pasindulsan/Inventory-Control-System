/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ui.stock;

import com.se.database.entities.Items;
import com.se.database.sql.ItemSQL;
import com.se.ui.dashboard.DashboardView;
import static com.se.ui.dashboard.DashboardView.DesktopPane;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gayani
 */
public class ManageItemListView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ItemListView
     */
    public ManageItemListView() {
        initComponents();
    }

    private DefaultTableModel dtmItems;
    private DefaultTableModel dtmSelectedItem;
    private final ItemDetailsView itView = new ItemDetailsView();
    private List<Items> list;
    private ArrayList<Object> items;

    public void initializeView() throws SQLException {

        setDtmItems();
        setDtmSelectedItem();
        resetTxt();
        list = ItemSQL.getAllItems();

        cbRemove.setSelected(false);
        btnRemove.setEnabled(false);
//        spinnerQty.setValue(0);

        cmbCategory.removeAllItems();
        cmbCategory.addItem("All Categories");

        List<String> groups = ItemSQL.getCategory();
        groups.forEach(group -> {
            cmbCategory.addItem(group);
        });
    }

    private void setDtmItems() {
        dtmItems = (DefaultTableModel) this.tblItemList.getModel();
        dtmItems.getDataVector().removeAllElements();
        dtmItems.fireTableDataChanged();
    }

    private void setDtmSelectedItem() {
        dtmSelectedItem = (DefaultTableModel) this.tblSelectedItem.getModel();
        dtmSelectedItem.getDataVector().removeAllElements();
        dtmSelectedItem.fireTableDataChanged();
    }

    private void resetTxt() {
        txtId.setText("");
    }

    private void searchAction(String name) throws SQLException {
        if (cmbCategory.getSelectedIndex() == 0) {
            list.forEach(item -> {
                if (item.getItem_Name().toLowerCase().contains(name.toLowerCase(Locale.ITALY))) {
                    dtmItems.addRow(new Object[]{item.getItem_Name(), item.getNet_qty()});
                }
            });
        } else {
            list.forEach(item -> {
                if (item.getItem_Name().toLowerCase().contains(name.toLowerCase(Locale.ITALY)) && item.getCategory().equals(cmbCategory.getSelectedItem().toString())) {
                    dtmItems.addRow(new Object[]{item.getItem_Name(), item.getNet_qty()});
                }
            });
        }
        if (tblItemList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No items found");
            resetTxt();
            cmbCategoryAction(cmbCategory.getSelectedIndex());
        }
    }

    private void cmbCategoryAction(int category) throws SQLException {
        switch (category) {
            case -1:
                break;

            case 0:
                list.forEach(items -> {
                    dtmItems.addRow(new Object[]{items.getItem_Name(), items.getNet_qty()});
                });
                break;

            default:
                list.forEach(item -> {
                    if (item.getCategory().equals(cmbCategory.getSelectedItem().toString()) && item.getNet_qty() > 0) {
                        dtmItems.addRow(new Object[]{item.getItem_Name(), item.getNet_qty()});
                    }
                });
                break;

        }
    }

    private void tblItemAction() {
        int row = tblItemList.getSelectedRow();
        if (row != -1) {
            list.forEach(item -> {
                if (item.getItem_Name().equals(tblItemList.getValueAt(row, 0).toString())) {
                    if (item != null) {
                        setDtmSelectedItem();
                        dtmSelectedItem.addRow(new Object[]{item.getItem_id(), item.getCategory(), item.getItem_Name(), item.getWarranty(), String.format("%.2f", item.getUnit_price())});
                    }
                }
            });
        } else {
            setDtmSelectedItem();
        }
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
        lblItem = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSelectedItem = new javax.swing.JTable();
        cbRemove = new javax.swing.JCheckBox();
        btnRemove = new javax.swing.JButton();
        cmbCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemList = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Item List");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblItem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblItem.setText("Item");
        jPanel1.add(lblItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 33, 20));

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 200, 23));

        tblSelectedItem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSelectedItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Catogory", "Item", "Warranty", "Unit Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelectedItem.getTableHeader().setReorderingAllowed(false);
        tblSelectedItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSelectedItemMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelectedItem);
        if (tblSelectedItem.getColumnModel().getColumnCount() > 0) {
            tblSelectedItem.getColumnModel().getColumn(0).setMinWidth(0);
            tblSelectedItem.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblSelectedItem.getColumnModel().getColumn(0).setMaxWidth(60);
            tblSelectedItem.getColumnModel().getColumn(1).setMinWidth(0);
            tblSelectedItem.getColumnModel().getColumn(1).setPreferredWidth(160);
            tblSelectedItem.getColumnModel().getColumn(1).setMaxWidth(160);
            tblSelectedItem.getColumnModel().getColumn(3).setMinWidth(0);
            tblSelectedItem.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblSelectedItem.getColumnModel().getColumn(3).setMaxWidth(120);
            tblSelectedItem.getColumnModel().getColumn(4).setMinWidth(0);
            tblSelectedItem.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblSelectedItem.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 635, 48));

        cbRemove.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbRemove.setText("Select to remove/edit the selected item of the list.");
        cbRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(cbRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 110, -1));

        cmbCategory.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Categories" }));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 240, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Category");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        tblItemList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblItemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItemList.getTableHeader().setReorderingAllowed(false);
        tblItemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItemList);
        if (tblItemList.getColumnModel().getColumnCount() > 0) {
            tblItemList.getColumnModel().getColumn(1).setMinWidth(0);
            tblItemList.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblItemList.getColumnModel().getColumn(1).setMaxWidth(90);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 340, 140));

        jSeparator1.setForeground(new java.awt.Color(0, 120, 212));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 630, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Selected Item");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRemoveActionPerformed
        if (cbRemove.isSelected()) {
            btnRemove.setEnabled(true);
        } else {
            btnRemove.setEnabled(false);
        }
    }//GEN-LAST:event_cbRemoveActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        try {
            setDtmItems();
            setDtmSelectedItem();
            resetTxt();
            cmbCategoryAction(cmbCategory.getSelectedIndex());
        } catch (SQLException ex) {
            Logger.getLogger(ManageItemListView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void tblItemListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemListMouseClicked
        if (evt.getButton() == 1) {
            if (evt.getClickCount() == 1) {
                tblItemAction();
            }
        }
    }//GEN-LAST:event_tblItemListMouseClicked

    private void tblSelectedItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelectedItemMouseReleased
        if (evt.getButton() == 1) {
            if (evt.getClickCount() == 1) {
                int row = tblSelectedItem.getSelectedRow();

                int item_id = Integer.parseInt(tblSelectedItem.getValueAt(0, 0).toString());

                if (row >= 0) {
                    itView.dispose();
                    DashboardView.DesktopPane.remove((Component) itView);
                    DashboardView.DesktopPane.add((Component) itView);
                    try {
                        itView.initializeView(item_id);
                    } catch (SQLException ex) {
                        Logger.getLogger(ManageItemListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    itView.setLocation((int) ((DesktopPane.getSize().width - itView.getSize().width) / 2), (int) ((DesktopPane.getSize().height - itView.getSize().height) / 2));
                    itView.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_tblSelectedItemMouseReleased

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        String name = txtId.getText();
        try {
            setDtmItems();
            searchAction(name);
        } catch (SQLException ex) {
            Logger.getLogger(ItemListView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtIdKeyReleased

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int count = tblSelectedItem.getRowCount();
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Please select an item", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            int input = JOptionPane.showConfirmDialog(this, "Do you want to remove the selected item?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == JOptionPane.YES_OPTION) {

                btnRemoveAction();
                JOptionPane.showMessageDialog(this, "The item was removed", "", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                DashboardView.DesktopPane.remove((Component) this);
                DashboardView.DesktopPane.add((Component) this);
                try {
                    this.initializeView();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemSelectorView.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.setLocation((int) ((DesktopPane.getSize().width - this.getSize().width) / 2), (int) ((DesktopPane.getSize().height - this.getSize().height) / 2));
                this.dispose();
                this.setVisible(true);

            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnRemoveAction() {
        int item_id = (int) tblSelectedItem.getValueAt(0, 0);
        int qty = 0;
        ItemSQL.setQty(item_id, qty);
    }

//    private void btnUpdateAction() {
//        int item_id = Integer.parseInt(tblSelectedItem.getValueAt(0, 0).toString());
//        int newqty = Integer.parseInt(spinnerQty.getValue().toString());
//        int oldqty = Integer.parseInt(tblSelectedItem.getValueAt(0, 5).toString());
//        int qty = newqty + oldqty;
//        ItemSQL.setQty(item_id, qty);
//
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemove;
    private javax.swing.JCheckBox cbRemove;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblItem;
    private javax.swing.JTable tblItemList;
    private javax.swing.JTable tblSelectedItem;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
