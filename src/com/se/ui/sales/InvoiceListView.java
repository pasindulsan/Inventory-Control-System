/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ui.sales;

import com.se.database.entities.Employee;
import com.se.database.entities.Transaction;
import com.se.database.sql.EmployeeSQL;
import com.se.database.sql.TransactionSQL;
import com.se.ui.dashboard.DashboardView;
import static com.se.ui.dashboard.DashboardView.DesktopPane;
import java.awt.Component;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BHARATHA
 */
public class InvoiceListView extends javax.swing.JInternalFrame {

    /**
     * Creates new form InvoiceListView
     */
    public InvoiceListView() {
        initComponents();
    }

    private DefaultTableModel dtmTrans;
    private List<Transaction> list;
    private List<Employee> empList;

//    private int aID;
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
        tblTrans = new javax.swing.JTable();
        pannelFilter = new javax.swing.JPanel();
        lblTransIDId = new javax.swing.JLabel();
        txtTransId = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        calDate = new com.toedter.calendar.JDateChooser();
        btnFilter = new javax.swing.JButton();
        btnSeeAll = new javax.swing.JButton();
        cbTransID = new javax.swing.JCheckBox();
        cbDate = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Invoice List");

        tblTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Made Date", "Transaction ID", "Net Quantity", "Net Total", "Employee Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTrans.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTrans);
        if (tblTrans.getColumnModel().getColumnCount() > 0) {
            tblTrans.getColumnModel().getColumn(1).setMinWidth(0);
            tblTrans.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblTrans.getColumnModel().getColumn(1).setMaxWidth(90);
            tblTrans.getColumnModel().getColumn(2).setMinWidth(0);
            tblTrans.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblTrans.getColumnModel().getColumn(2).setMaxWidth(90);
            tblTrans.getColumnModel().getColumn(3).setMinWidth(0);
            tblTrans.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblTrans.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        pannelFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 120, 212)), "Filter List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        lblTransIDId.setText("Transaction ID");

        txtTransId.setEnabled(false);

        lblDate.setText("Date");

        calDate.setEnabled(false);

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnSeeAll.setText("Clear All");
        btnSeeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeAllActionPerformed(evt);
            }
        });

        cbTransID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTransIDActionPerformed(evt);
            }
        });

        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelFilterLayout = new javax.swing.GroupLayout(pannelFilter);
        pannelFilter.setLayout(pannelFilterLayout);
        pannelFilterLayout.setHorizontalGroup(
            pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelFilterLayout.createSequentialGroup()
                .addGroup(pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelFilterLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pannelFilterLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(cbTransID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTransIDId)
                        .addGap(18, 18, 18)
                        .addComponent(txtTransId, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelFilterLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSeeAll, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelFilterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDate)
                        .addGap(18, 18, 18)
                        .addComponent(calDate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        pannelFilterLayout.setVerticalGroup(
            pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelFilterLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(calDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTransIDId)
                            .addComponent(txtTransId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate)))
                    .addComponent(cbTransID)
                    .addComponent(cbDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(pannelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter)
                    .addComponent(btnSeeAll))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pannelFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pannelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
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

    private void btnSeeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeAllActionPerformed
        setDtmTrans();
        resetTxt();
        list.forEach(item -> {
            String name = "";
            for (Employee emp : empList) {
                if (emp.getEmp_id() == item.getEmployee_emp_id()) {
                    name = emp.getTitle() + " " + emp.getName();
                }
            }
            dtmTrans.addRow(new Object[]{item.getMade_dateS(), item.getTrans_id(), item.getNet_qty(), String.format("%.2f", item.getNet_total()), name});
        });
    }//GEN-LAST:event_btnSeeAllActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (!cbTransID.isSelected() && !cbDate.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select filter criteria", "", JOptionPane.ERROR_MESSAGE);
        } else {
            if (cbTransID.isSelected() && !cbDate.isSelected()) {
                if (this.txtTransId.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter transaction ID", "", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    filterView1();
                }
            } else if (!cbTransID.isSelected() && cbDate.isSelected()) {
                if (calDate.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Please select the date", "", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    filterView2();
                }
            } else if (cbTransID.isSelected() && cbDate.isSelected()) {
                if (this.txtTransId.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter transaction ID", "", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (calDate.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Please enter transaction ID", "", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    filterView3();
                }
            }
            if (tblTrans.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No search results found");
                setDtmTrans();
                resetTxt();
                list.forEach(item -> {
                    String name = "";
                    for (Employee emp : empList) {
                        if (emp.getEmp_id() == item.getEmployee_emp_id()) {
                            name = emp.getTitle() + " " + emp.getName();
                        }
                    }
                    dtmTrans.addRow(new Object[]{item.getMade_dateS(), item.getTrans_id(), item.getNet_qty(), String.format("%.2f", item.getNet_total()), name});
                });
            }
        }


    }//GEN-LAST:event_btnFilterActionPerformed

    private void cbTransIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTransIDActionPerformed
        if (this.cbTransID.isSelected()) {
            this.txtTransId.setEnabled(true);
        } else {
            this.txtTransId.setEnabled(false);
        }
    }//GEN-LAST:event_cbTransIDActionPerformed

    private void cbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDateActionPerformed
        if (this.cbDate.isSelected()) {
            this.calDate.setEnabled(true);
        } else {
            this.calDate.setEnabled(false);
        }
    }//GEN-LAST:event_cbDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnSeeAll;
    private com.toedter.calendar.JDateChooser calDate;
    private javax.swing.JCheckBox cbDate;
    private javax.swing.JCheckBox cbTransID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTransIDId;
    private javax.swing.JPanel pannelFilter;
    private javax.swing.JTable tblTrans;
    private javax.swing.JTextField txtTransId;
    // End of variables declaration//GEN-END:variables

    public void initializeView(int id) {
//        this.aID = id;
        list = TransactionSQL.getAllItems();
        empList = EmployeeSQL.getAllEmployee();
        setDtmTrans();
        resetTxt();
        list.forEach(item -> {
            String name = "";
            for (Employee emp : empList) {
                if (emp.getEmp_id() == item.getEmployee_emp_id()) {
                    name = emp.getTitle() + " " + emp.getName();
                }
            }
            dtmTrans.addRow(new Object[]{item.getMade_dateS(), item.getTrans_id(), item.getNet_qty(), String.format("%.2f", item.getNet_total()), name});
        });

        tblTrans.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    //int column = target.getSelectedColumn(); // select a column
                    //JOptionPane.showMessageDialog(null, tblTrans.getValueAt(row, 1)); // get the value of a row and column.
                    int tblid = (Integer) tblTrans.getValueAt(row, 1);
                    String tblemp = tblTrans.getValueAt(row, 4).toString();
                    String tbldate = tblTrans.getValueAt(row, 0).toString();
                    String tbltotal = tblTrans.getValueAt(row, 3).toString();
                    InvoiceItemsView inv = new InvoiceItemsView();
                    DashboardView.DesktopPane.add((Component) inv);
                    inv.initializeView(tblid, tblemp, tbldate, tbltotal);
                    inv.setLocation((int) ((DesktopPane.getSize().width - inv.getSize().width) / 2), (int) ((DesktopPane.getSize().height - inv.getSize().height) / 2));
                    inv.setVisible(true);
                }
            }

        }
        );
    }

    private void setDtmTrans() {
        dtmTrans = (DefaultTableModel) this.tblTrans.getModel();
        dtmTrans.getDataVector().removeAllElements();
        dtmTrans.fireTableDataChanged();
    }

    private void resetTxt() {
        cbTransID.setSelected(false);
        txtTransId.setText("");
        cbDate.setSelected(false);
        calDate.setDate(null);
    }

    public void filterView1() {
        String id = this.txtTransId.getText();

        setDtmTrans();
//        resetTxt();
        list.forEach(item -> {
            String name = "";
            for (Employee emp : empList) {
                if (emp.getEmp_id() == item.getEmployee_emp_id()) {
                    name = emp.getTitle() + " " + emp.getName();
                }
            }
            if ((item.getTrans_id() == Integer.parseInt(id))) {
                dtmTrans.addRow(new Object[]{item.getMade_dateS(), item.getTrans_id(), item.getNet_qty(), String.format("%.2f", item.getNet_total()), name});
            }
        });
    }

    public void filterView2() {
        try {
            Date date = this.calDate.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = sdf.format(date);

            setDtmTrans();
//        resetTxt();
            list.forEach(item -> {
                String name = "";
                for (Employee emp : empList) {
                    if (emp.getEmp_id() == item.getEmployee_emp_id()) {
                        name = emp.getTitle() + " " + emp.getName();
                    }
                }
                if (item.getMade_dateS().substring(0, 10).equals(strDate)) {
                    dtmTrans.addRow(new Object[]{item.getMade_dateS(), item.getTrans_id(), item.getNet_qty(), String.format("%.2f", item.getNet_total()), name});
                }
            });
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Please enter  Date", "", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public void filterView3() {
        try {
            String id = this.txtTransId.getText();
            Date date = this.calDate.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = sdf.format(date);

            setDtmTrans();
//        resetTxt();
            list.forEach(item -> {
                String name = "";
                for (Employee emp : empList) {
                    if (emp.getEmp_id() == item.getEmployee_emp_id()) {
                        name = emp.getTitle() + " " + emp.getName();
                    }
                }
                if ((item.getTrans_id() == Integer.parseInt(id)) && item.getMade_dateS().substring(0, 10).equals(strDate)) {
                    dtmTrans.addRow(new Object[]{item.getMade_dateS(), item.getTrans_id(), item.getNet_qty(), String.format("%.2f", item.getNet_total()), name});
                }
            });
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Please enter  Date", "", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
