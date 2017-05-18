package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        List<String> params = Arrays.asList(URL.substring(URL.indexOf("?") + 1).split("&"));
        List<String> values = new ArrayList<>();

        for (String param : params) {
            String str = param;
            if (param.contains("=")) {
                str = param.substring(0,param.indexOf("="));
                if (str.equals("obj"))
                    values.add(param.substring(param.indexOf("=")+1));
            }
            System.out.print(str+" ");
        }

        System.out.println("");
        for (String value : values) {
            try
            {
                Double d = Double.parseDouble(value);
                alert(d);
            }
            catch (Exception e) {
                alert(value);
            }

        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
