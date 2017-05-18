package com.javarush.test.level27.lesson15.big01;

import java.util.List;

/**
 * Created by V.Kornev on 24.05.16.
 */
public class RandomOrderGeneratorTask implements Runnable
{
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted()){
            try
            {
                tablets.get((int)(Math.random()*tablets.size())).createTestOrder();
                Thread.sleep(interval);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
