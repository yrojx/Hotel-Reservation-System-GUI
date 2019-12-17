/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_reservation_system_gui;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Yossan
 */
public class Reservation {
    private String dayStart;
    private String dayEnd;
    private String paymentMethod;
    private int receptionistId;
    Room room;
    Customer customer;
    Payment payment;
    
    public Reservation(int noRoom, String type, float price, String paymentMethod, String id, String name, String phone, int receptionistId) {
        room = new Room(noRoom, type, price);
        
        if(paymentMethod.equalsIgnoreCase("cash")) {
            payment = new Cash(price);
        } else {
            payment = new Card(price);
        }
        customer = new Customer(id, name, phone, false);
        this.receptionistId = receptionistId;
    }
    
    public int bookRoom(String dayStart, String dayEnd, String paymentValue) {
        if(payment instanceof Cash) {
            ((Cash)payment).setTotalCash(Float.valueOf(paymentValue));
        } else {
            ((Card)payment).setNoCard(paymentValue);
        }
        if(payment.pay()) {
            MyConnection myConnection = new MyConnection();
            PreparedStatement ps1, ps2, ps3;
            String sql = "INSERT INTO customer VALUES (?, ?, ?, ?)";
            try {
                ps1 = myConnection.createConnection().prepareStatement(sql);
                ps1.setString(1, customer.getId());
                ps1.setString(2, customer.getName());
                ps1.setString(3, customer.getPhone());
                ps1.setBoolean(4, false);

                sql = "INSERT INTO booked_room VALUES (?, ?, ?, ?, ?)";
                ps2 = myConnection.createConnection().prepareStatement(sql);
                ps2.setInt(1, room.getRoomNo());
                ps2.setString(2, customer.getId());
                ps2.setInt(3, receptionistId);
                ps2.setString(4, dayStart);
                ps2.setString(5, dayEnd);

                sql = "UPDATE receptionist SET totalOfReservating = totalOfReservating + 1 WHERE id = ?";
                ps3 = myConnection.createConnection().prepareStatement(sql);
                ps3.setInt(1, receptionistId);

                if(ps1.executeUpdate() > 0 && ps2.executeUpdate() > 0 && ps3.executeUpdate() > 0) {
                    return 1;
                } else return 404;
            } catch (SQLException ex) {  
                System.out.println(ex);
                return 404;
            }
        } 
        
        return 406;
    }
    
    public Payment getPayment() {
        return payment;
    }
}
