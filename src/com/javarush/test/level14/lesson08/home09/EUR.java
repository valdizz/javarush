package com.javarush.test.level14.lesson08.home09;

/**
 * Created by V.Kornev on 29.02.16.
 */
public class EUR extends Money
{
    public EUR(double amount)
    {
        super(amount);
    }

    public String getCurrencyName(){
        return "EUR";
    }
}
