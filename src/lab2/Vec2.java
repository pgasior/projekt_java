package lab2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pgasior
 */
public class Vec2 {
    private float x;

    @Override
    public boolean equals(Object obj) {
        Vec2 comp = (Vec2)obj;
        if(this.x == comp.x && this.y == comp.y) {
            return true;
        }
        return false;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }
    
    private float y;

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }
    
    public Vec2() {
        
    }
    
    public Vec2(float x, float y) {
        this.x = x;
        this.y =y ;
        
    }
}
