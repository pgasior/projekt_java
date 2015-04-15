/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Piotrek
 */
public class Player {
    List<Warrior> players;// = new ArrayList<Warrior>();
    Random generator = new Random(System.currentTimeMillis());
    
    public Player(){
         players = new ArrayList<Warrior>();
    }
    
    public Player(List<Warrior> warriors){
        players = new ArrayList<Warrior>();
        for(int i=0;i<warriors.size();i++){
            this.players.add(warriors.get(i));
        }
    }
    
    public Warrior getWarrior(int i){
        return this.players.get(i);
    }
    
    public void addPlayer(Warrior newPlayer){
        this.players.add(newPlayer);
    }
    
    public void removePlayer(int i){
        this.players.remove(i);
    }
    
    public int getPlayerCount() {
        return this.players.size();
    }
    
    public void Attack(Player p2) {
        int przeciwnik = generator.nextInt(p2.getPlayerCount());
        int atakujacy = generator.nextInt(this.getPlayerCount());
        System.out.println(atakujacy+" atakuje "+przeciwnik);
        this.players.get(atakujacy).Attack(p2.getWarrior(przeciwnik));
        if (p2.getWarrior(przeciwnik).getPointsHealth() <= 0) {
            p2.removePlayer(przeciwnik);
        }
    }
    
}
