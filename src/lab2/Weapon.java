/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Filip
 */
public class Weapon {
    
    private int hitPoints;
    Weapon()
    {
        this.hitPoints=0;
    }
    Weapon(int power)
    {
        this.hitPoints=power;
    }
    
    

    /**
     * 
     * @return the hitPoints
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
