package com.javarush.test.level15.lesson12.home04;

/**
 * Created by V.Kornev on 02.03.16.
 */
public class Moon implements Planet
{
    private static volatile Moon instance;

    private Moon()  {}

    public static synchronized Moon getInstance()
    {
        if (instance == null)
            synchronized (Moon.class)
            {
                if (instance == null)
                    instance = new Moon();
            }
        return instance;
    }
}
