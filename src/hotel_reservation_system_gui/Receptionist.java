/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_reservation_system_gui;

import java.sql.*;

/**
 *
 * @author Yossan
 */
public class Receptionist {
    private int id;
    private String name;
    private String phone;
    private String password;
    private int totalOfReservating;
    private float salary;
    MyConnection myConnection;
    
    public Receptionist(int id) {
        this.id = id;
    }
    
    public Receptionist(String name, String phone, String password, int totalOfReservating, float salary) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.totalOfReservating = totalOfReservating;
        this.salary = salary;
    }
    
    public void salaryInfo() {
        System.out.println("Salary Info of " + name);
        System.out.println("Total of Reservating = " + totalOfReservating);
        System.out.println("Base Salary = " + salary);
        System.out.println("Total = " + (salary + ((float)totalOfReservating * 5)));
    }
    
    public boolean addReceptionist() {
        myConnection = new MyConnection(); 
        PreparedStatement ps;
        String sql = "INSERT INTO receptionist (name, phone, password, totalOfReservating, salary) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, password);
            ps.setInt(4, totalOfReservating);
            ps.setFloat(5, salary);
            
            if(ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
        
    }
    
    public boolean editReceptionist(int id) {
        boolean status = true;
        myConnection = new MyConnection(); 
        PreparedStatement ps;
        ResultSet rst;
        if(password.trim().equals("")){
            String sql = "UPDATE receptionist SET name = ?, phone = ?, salary = ? WHERE id = ?";
        
            try {
                ps = myConnection.createConnection().prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, phone);
                ps.setFloat(3, salary);
                ps.setInt(4, id);

                if(ps.executeUpdate() > 0) {
                    status = true;
                } else {
                    status = false;
                }

            } catch(SQLException e) {
                System.out.println(e);
                status = false;
            }
        } else {
            String sql = "UPDATE receptionist SET name = ?, phone = ?, password = ?, salary = ? WHERE id = ?";
        
            try {
                ps = myConnection.createConnection().prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, phone);
                ps.setString(3, password);
                ps.setFloat(4, salary);
                ps.setInt(5, id);

                if(ps.executeUpdate() > 0) {
                    status = true;
                } else {
                    status = false;
                }

            } catch(SQLException e) {
                System.out.println(e);
                status = false;
            }
        }
        return status;
    }
    
    public boolean deleteReceptionist() {
        myConnection = new MyConnection(); 
        PreparedStatement ps;
        String sql = "DELETE FROM receptionist WHERE id = ?";
        try {
            ps = myConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            
            return (ps.executeUpdate() > 0);
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
}