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
public class Gra {

    Player p1 = new Player();
    Player p2 = new Player();

    List<Player> players = new ArrayList<Player>();
    int end_game;
    Random generator;
    int aktualny;
    int arena_width = 10;
    int arena_height = 10;

    public Gra() {
        this.end_game = 0;
        generator = new Random(System.currentTimeMillis());
        aktualny = generator.nextInt(2);
        ustawGraczy();
        
    }
    
    public void ustawGraczy(){
        List<Weapon> bronieCzlowieka = new ArrayList<Weapon>();
        BialaBron miecz = new BialaBron(160);
        BronPalna pistolet = new BronPalna(300);
        bronieCzlowieka.add(miecz);
        bronieCzlowieka.add(pistolet);

        List<Weapon> BronieKosmity = new ArrayList<Weapon>();
        DzidaLaserowa dzida = new DzidaLaserowa(400);
        BronieKosmity.add(dzida);

        List<Mover> transport = new ArrayList<Mover>();
        Mover mover1 = new Buty(60);
        //mover1.setMovePoints(60);
        transport.add(mover1);


        players.add(p1);
        players.add(p2);
        for (int i = 0; i < 5; i++) {
            players.get(0).addPlayer(new Warrior(bronieCzlowieka, transport, 30, 20, 1));
            players.get(0).getWarrior(i).setPosition(new Vec2(i,0));
            
        }

        for (int i = 0; i < 5; i++) {
            players.get(1).addPlayer(new Warrior(BronieKosmity, transport, 35, 20, 1));
            players.get(1).getWarrior(i).setPosition(new Vec2(i,arena_width));
        }
        
    }

    public void graj() {

        System.out.print("Zaczyna gracz ");
        System.out.println(aktualny);
        //int przeciwnik;
        //int atakujacy;
        while (end_game == 0) {
            System.out.println("-------------------------------");
            System.out.println("Przed Atakiem:");
            for (int j = 0; j < 2; j++) {
                System.out.println("Gracz " + j);
                for (int i = 0; i < players.get(j).getPlayerCount(); i++) {
                    System.out.print(i);
                    System.out.print(": ");
                    System.out.print(players.get(j).getWarrior(i).getPointsHealth());
                    System.out.println(players.get(j).getWarrior(i).getPositionString());
                }
                System.out.println();
            }
            
           
            System.out.println("Atakuje druzyna "+aktualny);
            players.get(aktualny).Attack(players.get((aktualny+1)%2));
            if(players.get((aktualny + 1) % 2).getPlayerCount()==0){
                end_game=aktualny;
            }
            else{
                aktualny=(aktualny+1)%2;
            }
            
            System.out.println("Po Ataku:");
            for (int j = 0; j < 2; j++) {
                System.out.println("Gracz " + j);
                for (int i = 0; i < players.get(j).getPlayerCount(); i++) {
                    System.out.print(i);
                    System.out.print(": ");
                    System.out.print(players.get(j).getWarrior(i).getPointsHealth());
                    System.out.println(players.get(j).getWarrior(i).getPositionString());
                }
                System.out.println();
            }
            System.out.println("-------------------------------");

        }
        System.out.println("Koniec Gry");
    }

}
