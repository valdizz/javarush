package com.javarush.test.level40.lesson10.task01;

/* Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответсвии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1
AM или PM: 1
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1

3) Для "17:33:40":
AM или PM: 1
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        String pattern1 = "dd.MM.yyyy HH:mm:ss";
        String pattern2 = "dd.MM.yyyy";
        String pattern3 = "HH:mm:ss";
        SimpleDateFormat format;
        Date fdate = null;
        if (date.length()>10){
            format = new SimpleDateFormat(pattern1);}
        else if (date.contains(".")){
            format = new SimpleDateFormat(pattern2);}
        else{
            format = new SimpleDateFormat(pattern3);}

        try
        {
            fdate = format.parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fdate);

        if (date.length()>10){
            showDateInfo(calendar);
            showTimeInfo(calendar);
        }
        else if (date.contains(".")){
            showDateInfo(calendar);
        }
        else{
            showTimeInfo(calendar);
        }
    }

    private static void showTimeInfo(Calendar cal)
    {
        System.out.println("AM или PM: " + cal.get(Calendar.AM_PM));
        System.out.println("Часы: " + cal.get(Calendar.HOUR));
        System.out.println("Часы дня: " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + cal.get(Calendar.MINUTE));
        System.out.println("Секунды: " + cal.get(Calendar.SECOND));
    }

    private static void showDateInfo(Calendar cal)
    {
        System.out.println("День: " + cal.get(Calendar.DATE));
        System.out.println("День недели: " + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("День месяца: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + cal.get(Calendar.MONTH));
        System.out.println("Год: " + cal.get(Calendar.YEAR));
        System.out.println("Эра: " + cal.get(Calendar.ERA));
    }
}
