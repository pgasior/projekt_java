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
public class DzidaLaserowa extends BronPalna {
    
    //int dlugosc = 6;
    //int sila = 20;
    public DzidaLaserowa(){
        super();
        dlugosc+=6;
        sila+=15;
    }
    
    public DzidaLaserowa(int power){
        super(power);
        dlugosc+=6;
        sila+=15;
    }
    
    @Override
    public int getHitPoints() {
        return super.getHitPoints() * sila + dlugosc;
    }
    
}
