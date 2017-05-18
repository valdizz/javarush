package com.javarush.test.level14.lesson08.bonus01;

import sun.security.util.PropertyExpander;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] aaa = new int[3];
            aaa[5] = 1;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileReader fileReader = new FileReader("fdf.ccc");

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object x[] = new String[3];
            x[0] = new Integer(0);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] aaa = new int[-3];
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalAccessException("demo");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new EmptyStackException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new EOFException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new DuplicateFormatFlagsException("sdsd");
        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
