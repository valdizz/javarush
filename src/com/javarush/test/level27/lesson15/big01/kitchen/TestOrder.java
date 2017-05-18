package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by V.Kornev on 24.05.16.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes()
    {
        dishes = new ArrayList<>();
        Dish[] dishList = Dish.values();
        for (int i=0; i<dishList.length*Math.random(); i++){
            dishes.add(dishList[(int) (Math.random()*dishList.length)]);
        }
    }
}
