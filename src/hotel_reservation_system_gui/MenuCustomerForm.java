/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_reservation_system_gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yossan
 */
public class MenuCustomerForm extends javax.swing.JFrame {
    private Customer customer;
    /**
     * Creates new form MenuCustomerForm
     */
    public MenuCustomerForm() {
        initComponents();
        customer = new Customer();
        initTable();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomer = new javax.swing.JTable();
        jButtonCheckIn = new javax.swing.JButton();
        jButtonCheckOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        jLabel1.setText("CUSTOMER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Phone", "Room No", "Day Start", "Day End", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTableCustomer);

        jButtonCheckIn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCheckIn.setText("Check In");
        jButtonCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckInActionPerformed(evt);
            }
        });

        jButtonCheckOut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCheckOut.setText("Check Out");
        jButtonCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jButtonCheckIn)
                .addGap(155, 155, 155)
                .addComponent(jButtonCheckOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCheckOut)
                    .addComponent(jButtonCheckIn))
                .addGap(0, 41, Short.MAX_VALUE))
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

    private void jButtonCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckOutActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTableCustomer.getModel();
        int rIndex = jTableCustomer.getSelectedRow();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        
        if(rIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "Click the data first", "Empty Fields", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Date d1 = sdformat.parse(tableModel.getValueAt(rIndex, 5).toString());
                Date d2 = sdformat.parse(timeStamp);
                Date d3 = sdformat.parse(tableModel.getValueAt(rIndex, 4).toString());
                if(d3.compareTo(d2) <= 0 && Integer.valueOf(tableModel.getValueAt(rIndex, 6).toString()) == 1) {
                    customer = new Customer(tableModel.getValueAt(rIndex, 0).toString(), tableModel.getValueAt(rIndex, 1).toString(), tableModel.getValueAt(rIndex, 2).toString(), Boolean.valueOf(tableModel.getValueAt(rIndex, 6).toString()));
                    if(customer.checkOut()) {
                        JOptionPane.showMessageDialog(rootPane, "Checked Out", "Customer Check Out", JOptionPane.INFORMATION_MESSAGE);
                        initTable();
                        
                        CheckOutForm checkOutForm = new CheckOutForm(d2.compareTo(d1));
                        checkOutForm.setVisible(true);
                        checkOutForm.pack();
                        checkOutForm.setLocationRelativeTo(null);
                        checkOutForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Failed to Check Out", "Customer Check In Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Failed to Check Out", "Customer Check In Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParseException ex) {
                Logger.getLogger(MenuCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButtonCheckOutActionPerformed
    
    private void jButtonCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckInActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTableCustomer.getModel();
        int rIndex = jTableCustomer.getSelectedRow();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        
        if(rIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "Click the data first", "Empty Fields", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Date d1 = sdformat.parse(tableModel.getValueAt(rIndex, 4).toString());
                Date d2 = sdformat.parse(timeStamp);
                if(d1.compareTo(d2) == 0 && Integer.valueOf(tableModel.getValueAt(rIndex, 6).toString()) == 0) {
                    customer = new Customer(tableModel.getValueAt(rIndex, 0).toString(), tableModel.getValueAt(rIndex, 1).toString(), tableModel.getValueAt(rIndex, 2).toString(), Boolean.valueOf(tableModel.getValueAt(rIndex, 6).toString()));
                    if(customer.checkIn()) {
                        JOptionPane.showMessageDialog(rootPane, "Checked In", "Customer Check In", JOptionPane.INFORMATION_MESSAGE);
                        initTable();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Failed to Check In", "Customer Check In Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Failed to Check In", "Customer Check In Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParseException ex) {
                Logger.getLogger(MenuCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButtonCheckInActionPerformed
    
    private void initTable() {
        jTableCustomer.setModel(new DefaultTableModel(null, new Object[]{"Id", "Name", "Phone", "Room No", "Day Start", "Day End", "Status"}) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
        }});
        customer.showCustomer(jTableCustomer);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCheckIn;
    private javax.swing.JButton jButtonCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCustomer;
    // End of variables declaration//GEN-END:variables
}
