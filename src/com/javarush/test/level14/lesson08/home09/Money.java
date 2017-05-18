package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double mani;
    public Money(double amount)
    {
        this.mani = amount;
    }

    public double getAmount() {
        return mani;
    }

    public abstract String getCurrencyName();
}

