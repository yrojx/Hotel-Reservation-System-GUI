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
public class Room {
    private int roomNo;
    private String type;
    private float price;
    
    public Room() {
        
    }
    
    public Room(int roomNo, String type, float price) {
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
    }
    
    public void showRoomInfo(JTable table) {
        MyConnection myConnection = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        String sql = "SELECT * FROM room";
        
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            rst = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            while(rst.next()) {
                row = new Object[3];
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2] = rst.getFloat(3);
                
                tableModel.addRow(row);
            }
            
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public void showBookedRoom(JTable table) {
        MyConnection myConnection = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        String sql = "SELECT room_no, day_start, day_end FROM booked_room";
        
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            rst = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            while(rst.next()) {
                row = new Object[3];
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2] = rst.getString(3);
                
                tableModel.addRow(row);
            }
            
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public boolean addRoom() {
        MyConnection myConnection = new MyConnection();
        PreparedStatement ps;
        String sql = "INSERT INTO room VALUES (?, ?, ?)";
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, roomNo);
            ps.setString(2, type);
            ps.setFloat(3, price);
            
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
    
    public boolean editRoom() {
        MyConnection myConnection = new MyConnection();
        PreparedStatement ps;
        String sql = "UPDATE room SET no = ?, type = ?, price = ? WHERE no = ?";
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, roomNo);
            ps.setString(2, type);
            ps.setFloat(3, price);
            ps.setInt(4, roomNo);
            
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
    
    public boolean deleteRoom() {
        MyConnection myConnection = new MyConnection(); 
        PreparedStatement ps;
        String sql = "DELETE FROM room WHERE no = ?";
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, roomNo);
            
            return (ps.executeUpdate() > 0);
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public int getRoomNo() {
        return roomNo;
    }
    
    public String getType() {
        return type;
    }
    
    public float getPrice() {
        return price;
    }
}
