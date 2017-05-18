package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by V.Kornev on 29.02.16.
 */
public class Singleton
{
    private static Singleton singleton;

    private Singleton() {
    }

    public static synchronized Singleton getInstance(){
        if (singleton==null)
            singleton=new Singleton();
        return singleton;
    }
}
