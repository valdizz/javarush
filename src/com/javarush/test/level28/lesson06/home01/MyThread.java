package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by V.Kornev on 05.05.16.
 */
public class MyThread extends Thread
{
    public static AtomicInteger prior = new AtomicInteger(0);

    public MyThread()
    {
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }

    public MyThread(Runnable target)
    {
        super(target);
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }

    public MyThread(String name)
    {
        super(name);
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        if (prior.get()==10)
            prior.set(0);
        setPriority(prior.incrementAndGet() > this.getThreadGroup().getMaxPriority() ? this.getThreadGroup().getMaxPriority() : prior.get());
    }
}
