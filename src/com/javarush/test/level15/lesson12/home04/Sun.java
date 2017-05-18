package com.javarush.test.level15.lesson12.home04;

/**
 * Created by V.Kornev on 02.03.16.
 */
public class Sun implements Planet
{
    private static volatile Sun instance;

    private Sun()  {}

    public static synchronized Sun getInstance() {
        if (instance==null)
            synchronized (Sun.class) {
                if (instance==null)
                    instance = new Sun();
            }
        return instance;
    }
}
