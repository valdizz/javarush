package com.javarush.test.level40.lesson10.task02;

/* Работа с Joda Time
Выполни задание, используя библиотеку Joda Time версии 2.9.1
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

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        DateTime joda = new DateTime(fdate);

        if (date.length()>10){
            showDateInfo(joda);
            showTimeInfo(joda);
        }
        else if (date.contains(".")){
            showDateInfo(joda);
        }
        else{
            showTimeInfo(joda);
        }
    }

    private static void showTimeInfo(DateTime joda)
    {
        System.out.println("AM или PM: " + (joda.getHourOfDay()>=12 ? 1: 0));
        System.out.println("Часы: " + (joda.getHourOfDay()>=12 ? joda.getHourOfDay()-12: joda.getHourOfDay()));
        System.out.println("Часы дня: " + joda.getHourOfDay());
        System.out.println("Минуты: " + joda.getMinuteOfHour());
        System.out.println("Секунды: " + joda.getSecondOfMinute());
    }

    private static void showDateInfo(DateTime joda)
    {
        System.out.println("День: " + joda.getDayOfMonth());
        System.out.println("День недели: " + (joda.getDayOfWeek()+1));
        System.out.println("День месяца: " + joda.getDayOfMonth());
        System.out.println("День года: " + joda.getDayOfYear());
        DateTime minYearDate = joda.dayOfYear().withMinimumValue();
        DateTime minMonthDate = joda.dayOfMonth().withMinimumValue();
        int weekDis = (minYearDate.getWeekyear() == joda.getYear()) ? 0 : 1;
        int weekOfYear = joda.getWeekOfWeekyear() + weekDis;
        if (weekOfYear >= 53)
            weekOfYear = 1;
        int weekOfMonth = joda.getWeekOfWeekyear() - minMonthDate.getWeekOfWeekyear() + 1;
        if (minMonthDate.getWeekOfWeekyear() >= joda.getWeekOfWeekyear())
            weekOfMonth = joda.minusDays(7).getWeekOfWeekyear() - minMonthDate.getWeekOfWeekyear() + 2;
        if (joda.getMonthOfYear() == 1)
            weekOfMonth = weekOfYear;
        System.out.println("Неделя месяца: " + weekOfMonth);
        System.out.println("Неделя года: " + weekOfYear);
        System.out.println("Месяц: " + (joda.getMonthOfYear()-1));
        System.out.println("Год: " + joda.getYear());
        System.out.println("Эра: " + joda.getEra());
    }

}
