/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_reservation_system_gui;

/**
 *
 * @author User
 */
public class PaymentFactory {
    Payment obj = null;
    public Payment getPayment(String method, float amount) {
        if(method.equalsIgnoreCase("cash")) obj = new Cash(amount);
        else obj = new Card(amount);
        
        return obj;
    }
}
