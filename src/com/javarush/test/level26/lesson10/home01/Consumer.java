package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;
/**
 * Created by V.Kornev on 28.04.16.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                String msg = (String)queue.take();
                System.out.println(msg);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
