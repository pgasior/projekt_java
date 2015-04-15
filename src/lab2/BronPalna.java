/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Piotrek
 */
public class BronPalna extends Weapon {
    
    protected int dlugosc = 6;
    protected int sila = 10;
    
    public BronPalna(){
        super();
    }
    
    public BronPalna(int power){
        super(power);
    }
    
    @Override
    public int getHitPoints() {
        return super.getHitPoints() * sila + dlugosc;
    }
}
