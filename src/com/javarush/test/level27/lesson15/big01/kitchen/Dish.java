package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by V.Kornev on 19.05.16.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString(){
        StringBuilder sb = new StringBuilder();
        for (Dish dish :Dish.values()){
            sb.append(dish).append(", ");
        }
        return sb.substring(0,sb.length()-2);
    }
}
