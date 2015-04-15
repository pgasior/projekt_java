/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2;

/**
 *
 * @author fzeglen
 */
public class BialaBron extends Weapon {
    
    protected float dlugosc = 2;
    protected float ostrosc = 2;
    
    public BialaBron()
    { 
        super();
    }
    
    public BialaBron(int power){
        super(power);
    }

    @Override
    public int getHitPoints() {
        return super.getHitPoints() * (int)dlugosc + (int)ostrosc;
    }
    
}
