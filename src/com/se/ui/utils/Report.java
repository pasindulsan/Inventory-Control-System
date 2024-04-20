/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ui.utils;

import com.se.database.utils.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author BHARATHA
 */
public class Report {

    public String reportDir = System.getProperty("user.dir") + "/Reports/";

    public void generateReport(String reportname, Map params, OrientationEnum orientation) {
        Connection conn = new Connect().conn();
        try {
            JasperReport jr = JasperCompileManager.compileReport(reportDir + reportname);
            jr.setWhenNoDataType(WhenNoDataTypeEnum.NO_PAGES);

            JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);
            jp.setOrientation(orientation);
            List<JRPrintPage> p = jp.getPages();

            if (!p.isEmpty()) {
                JasperViewer.viewReport(jp, false);
            } else {
                JOptionPane.showMessageDialog(null, "NO PAGES !!!!");
            }
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
