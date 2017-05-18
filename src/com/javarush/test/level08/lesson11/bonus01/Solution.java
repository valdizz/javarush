package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        HashMap<Integer, String> months = new HashMap<Integer,String>();
        Locale locale = Locale.ENGLISH;
        Calendar calendar = new GregorianCalendar(2015,0,1);
        for (int i=1; i<=12; i++) {
            months.put(i,calendar.getDisplayName(Calendar.MONTH,Calendar.LONG,locale));
            calendar.roll(Calendar.MONTH,1);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        for (Map.Entry<Integer,String> map : months.entrySet()) {
            if (map.getValue().equals(month)) {
                System.out.println(month+" is "+map.getKey()+" month");
            }
        }


    }

}
