package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by V.Kornev on 21.10.16.
 */
public class Woman implements Human
{
    @Override
    public String toString()
    {
        return getClass().getSimpleName()+"{}";
    }
}
