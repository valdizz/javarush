package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by V.Kornev on 20.05.16.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;;
    }

    public Object getContent()
    {
        return content;
    }

    public void setContent(Object content)
    {
        this.content = content;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getInitialAmount()
    {
        return initialAmount;
    }

    public void setInitialAmount(long initialAmount)
    {
        this.initialAmount = initialAmount;
    }

    public int getHits()
    {
        return hits;
    }

    public void setHits(int hits)
    {
        this.hits = hits;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public void setAmountPerOneDisplaying(long amountPerOneDisplaying)
    {
        this.amountPerOneDisplaying = amountPerOneDisplaying;
    }

    public void revalidate(){
        if (hits <= 0)
            throw new UnsupportedOperationException();
        hits--;
        if (hits == 1)
            amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;
    }
}
