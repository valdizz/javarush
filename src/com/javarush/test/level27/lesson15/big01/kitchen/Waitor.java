package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by V.Kornev on 20.05.16.
 */
public class Waitor implements Observer
{
    @Override
    public void update(Observable observable, Object arg)
    {
        Order order = (Order) arg;
        Cook cook = (Cook) observable;
        ConsoleHelper.writeMessage(order.toString() + " was cooked by " + cook.toString());
    }
}
