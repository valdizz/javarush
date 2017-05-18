package com.javarush.test.level08.lesson11.home09;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inpdate = reader.readLine();
        System.out.println(isDateOdd(inpdate));
    }

    public static boolean isDateOdd(String date)
    {
        Date datnow = new Date(date);
        Date dayfirst = new Date();
        dayfirst.setYear(datnow.getYear());
        dayfirst.setMonth(0);
        dayfirst.setDate(1);
        dayfirst.setHours(0);
        dayfirst.setMinutes(0);
        dayfirst.setSeconds(0);
        long msTimeDistace = datnow.getTime() - dayfirst.getTime();
        int dayz = (int) ((msTimeDistace+1000) / (1000 * 60 * 60 * 24));
        if ((dayz+1) % 2 != 0)
            return true;
        else
            return false;
    }
}
