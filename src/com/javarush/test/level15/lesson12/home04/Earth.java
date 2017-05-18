package com.javarush.test.level15.lesson12.home04;

/**
 * Created by V.Kornev on 02.03.16.
 */
public class Earth implements Planet
{
    private static volatile Earth instance;

    private Earth()  {}

    public static synchronized Earth getInstance() {
        if (instance==null)
            synchronized (Earth.class) {
                if (instance==null)
                    instance = new Earth();
            }
        return instance;
    }

}