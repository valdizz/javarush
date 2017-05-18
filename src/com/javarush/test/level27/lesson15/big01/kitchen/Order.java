package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;


/**
 * Created by V.Kornev on 19.05.16.
 */
public class Order
{
    private Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException{
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (!dishes.isEmpty())
            sb.append("Your order: ").append(dishes).append(" of ").append(tablet.toString());
        return sb.toString();
    }

    public int getTotalCookingTime(){
        int totalCookingTime = 0;
        for (Dish dish : dishes){
            totalCookingTime += dish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

}
