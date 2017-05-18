package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by V.Kornev on 19.05.16.
 */
public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {
        Cook cookAmigo = new Cook("Amigo");
        cookAmigo.setQueue(queue);
        Thread cookAmigoThread = new Thread(cookAmigo);
        cookAmigoThread.setDaemon(true);
        cookAmigoThread.start();
        Cook cookDimon = new Cook("Dimon");
        cookDimon.setQueue(queue);
        Thread cookDimonThread = new Thread(cookDimon);
        cookDimonThread.setDaemon(true);
        cookDimonThread.start();
        Waitor waitor = new Waitor();
        cookAmigo.addObserver(waitor);
        cookDimon.addObserver(waitor);

        List tablets = new ArrayList<Tablet>();
        for (int i=1; i<=5; i++){
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.setQueue(queue);
        }

        Thread restaurantTask = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        restaurantTask.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException nothing) {
        }
        restaurantTask.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
