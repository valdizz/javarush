package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by V.Kornev on 19.05.16.
 */
public class Cook extends Observable implements Runnable
{
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    public void startCookingOrder(Order order){
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()+", cooking time "+order.getTotalCookingTime()+"min");
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.toString(),name,order.getTotalCookingTime()*60,order.getDishes()));
        try{
            Thread.sleep(order.getTotalCookingTime() * 10);
        }catch (InterruptedException e){}
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    public boolean isBusy()
    {
        return busy;
    }

    @Override
    public void run()
    {
        while (true){
            if (!this.isBusy() && !queue.isEmpty())
            {
                Order order = queue.poll();
                startCookingOrder(order);
            }
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e){}
        }
    }
}
