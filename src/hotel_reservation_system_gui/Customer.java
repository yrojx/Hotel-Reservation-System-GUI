/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_reservation_system_gui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yossan
 */
public class Customer {
    private String id;
    private String name;
    private String phone;
    private boolean status;
    
    public Customer() {
        
    }
    
    public Customer(String id, String name, String phone, boolean status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.status = status;
    }
   
    
    public boolean checkIn() {
        MyConnection myConnection = new MyConnection();
        PreparedStatement ps;
        String sql = "UPDATE customer SET status = 1 WHERE id = ?";
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            ps.setString(1, id);
            if(ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean checkOut() {
        MyConnection myConnection = new MyConnection();
        PreparedStatement ps;
        String sql = "UPDATE customer SET status = -1 WHERE id = ?";
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            ps.setString(1, id);
            if(ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void showCustomer(JTable table) {
        MyConnection myConnection = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        String sql = "SELECT customer.id, customer.name, customer.phone, room.no, booked_room.day_start, booked_room.day_end, customer.status FROM (booked_room INNER JOIN customer ON booked_room.customer_id = customer.id) INNER JOIN room ON booked_room.room_no = room.no ORDER BY booked_room.day_start";
        
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            rst = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            while(rst.next()) {
                row = new Object[7];
                row[0] = rst.getString(1);
                row[1] = rst.getString(2);
                row[2] = rst.getString(3);
                row[3] = rst.getInt(4);
                row[4] = rst.getString(5);
                row[5] = rst.getString(6);
                row[6] = rst.getInt(7);
                
                tableModel.addRow(row);
            }
            
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phone;
    }
}
