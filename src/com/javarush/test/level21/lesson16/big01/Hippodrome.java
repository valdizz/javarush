package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by V.Kornev on 06.04.16.
 */
public class Hippodrome
{
    public static void main(String[] args){
        game = new Hippodrome();
        Horse horse1 = new Horse("horse1",3,0);
        Horse horse2 = new Horse("horse2",3,0);
        Horse horse3 = new Horse("horse3",3,0);
        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);

        game.run();

        game.printWinner();

    }

    private static ArrayList<Horse> horses = new ArrayList<Horse>();

    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run(){
        for (int i=1; i<=100; i++){
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void move(){
        for (Horse horse : horses){
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse max = null;
        for (Horse horse : getHorses()){
            if (horse.getDistance() > (max == null ? 0 : max.getDistance()))
                max = horse;
        }
        return max;
    }

    public void printWinner(){
        System.out.println("Winner is "+ getWinner().getName()+ "!");
    }
}
