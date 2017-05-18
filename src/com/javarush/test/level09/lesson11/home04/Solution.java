package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
        try
        {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(reader.readLine());
            System.out.println(dateFormat.format(date).toUpperCase());
//            System.out.println(date.getYear());
//            System.out.println(date.getMonth());
//            System.out.println(date.getDay());
//
//            System.out.println(date.toString());
        }
        catch (Exception e) {
            System.out.println("Ошибка формата даты!");
        }
    }
}
