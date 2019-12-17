/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_reservation_system_gui;

/**
 *
 * @author Yossan
 */
abstract public class Payment {
    protected float amount;
    
    public Payment(float amount) {
        this.amount = amount;
    }
    
    abstract public boolean pay();
    
    public float getAmount() {
        return amount;
    }
}
