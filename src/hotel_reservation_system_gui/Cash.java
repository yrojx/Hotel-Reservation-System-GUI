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
public class Cash extends Payment {
    private float totalCash;
    private float change;
    
    public Cash(float amount) {
        super(amount);
    }
    @Override
    public boolean pay() {
        if(totalCash < amount) {
            return false;
        }
        return true;
    }
    
    public void setTotalCash(float totalCash) {
        this.totalCash = totalCash;
    }
    
}
