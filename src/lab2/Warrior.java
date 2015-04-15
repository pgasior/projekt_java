/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class Warrior {
    
    public static final int MAX_ATT_POINTS = 100;
    public static final int MAX_MOVE_POINTS = 100;
    public static final int MAX_HEALTH_POINTS = 10;
    
    protected float lvlAttack; // 0 - MAX_ATT_POINTS
    protected float lvlMove;  // 0 - MAX_MOVE_POINTS 
    protected float lvlHealth; // 0 - MAX_HEALTH_POINTS
    
    protected float pointsAttack;
    protected float pointsMove;    
    protected float pointsHealth;
    
    List<Weapon> bronie = new ArrayList<Weapon>();
    List<Mover> transport = new ArrayList<Mover>();
    Vec2 position = new Vec2();
    
    public Warrior(List<Weapon> bronie, List<Mover> transport, int lvlA, int lvlM, int lvlH) {
        this.bronie = bronie;
        this.transport = transport;
        
        this.lvlAttack = lvlA;
        this.lvlMove = lvlM;
        this.lvlHealth = lvlH;
        this.pointsHealth = 100;
    }

    /**
     * @return the pointsAttack
     */
    public float getPointsAttack() {
        float ret = 0;
        for (int i = 0; i < bronie.size(); i++) {
            Weapon wp = (Weapon) bronie.get(i);
            ret += wp.getHitPoints();
        }        
        if (ret > 0) {
            ret *= lvlAttack / MAX_ATT_POINTS;            
        }        
        
        return ret;
    }

    /**
     *
     * /
     *
     **
     * @return the pointsMove
     */
    public float getPointsMove() {
        float ret = 0;
        for (int i = 0; i < transport.size(); i++) {
            Mover mv = (Mover) transport.get(i);
            ret += mv.getMovePoints();
        }        
        if (ret > 0) {
            ret *= lvlMove / MAX_MOVE_POINTS;            
        }        
        
        return ret;
    }
    
    public float getPointsHealth() {
        return pointsHealth * getLvlHealth();        
    }
    
    public float getAttackWithMove() {
        
        return getPointsAttack() / getPointsMove();
    }
    
    private boolean goTo(Vec2 destination){
        int move = (int)this.getPointsMove();
        System.out.println("Move: "+move);
        boolean donex = false;
        boolean doney = false;
        while(move>0){
            if(abs(this.position.getX()-destination.getX())>1){
                if(this.position.getX()<destination.getX())
                    this.position.setX(this.position.getX()+1);
                else
                    this.position.setX(this.position.getX()-1);
            }
            else if(abs(this.position.getY()-destination.getY())>1){
                if(this.position.getY()<destination.getY())
                    this.position.setY(this.position.getY()+1);
                else
                    this.position.setY(this.position.getY()-1);
            }
            move--;
            
        }
        return (abs(this.position.getX()-destination.getX())<=1) &&(abs(this.position.getY()-destination.getY())<=1);
    }
    
    public void Attack(Warrior Defender) {        
        if(this.goTo(Defender.getPosition())){
            Defender.setPointsHealth(Defender.getPointsHealth() - this.getAttackWithMove());
        }
        
        if (Defender.getPointsHealth() <= 0) {
            Defender.setPointsHealth(0);
        }
        
    }

    /**
     * @return the lvlHealth
     */
    public float getLvlHealth() {
        return lvlHealth;
    }

    /**
     * @param lvlHealth the lvlHealth to set
     */
    public void setLvlHealth(float lvlHealth) {
        this.lvlHealth = lvlHealth;
    }

    /**
     * @param pointsHealth the pointsHealth to set
     */
    public void setPointsHealth(float pointsHealth) {
        this.pointsHealth = pointsHealth;
    }
    
    public Vec2 getPosition() {
        return this.position;
    }
    
    public void setPosition(Vec2 newPos) {
        this.position.setX(newPos.getX());
        this.position.setY(newPos.getY());
    }
    
    public String getPositionString(){
        return " ("+this.position.getX() +","+this.position.getY()+")";
    }
    
}
