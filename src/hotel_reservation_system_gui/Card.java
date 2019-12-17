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
public class Card extends Payment {
    String noCard;
    public Card(float amount) {
        super(amount);
    }

    @Override
    public boolean pay() {
        return true;
    }
    
    public void setNoCard(String noCard) {
        this.noCard = noCard;
    }
}
