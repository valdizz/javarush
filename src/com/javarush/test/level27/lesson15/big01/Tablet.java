package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by V.Kornev on 19.05.16.
 */
public class Tablet
{
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    public void createOrder()
    {
        Order order = null;
        try
        {
            order = new Order(this);
            processOrderCreating(order);
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        catch (InterruptedException e){}
    }

    private void processOrderCreating(Order order) throws InterruptedException
    {
        if (!order.isEmpty())
        {
            ConsoleHelper.writeMessage(order.toString());
            queue.put(order);
            AdvertisementManager adManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            adManager.processVideos();
        }
    }

    public void createTestOrder(){
        TestOrder order = null;
        try
        {
            order = new TestOrder(this);
            processOrderCreating(order);
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        catch (InterruptedException e){}
    }

    @Override
    public String toString()
    {
        return "Tablet{number="+number+"}";
    }

}
