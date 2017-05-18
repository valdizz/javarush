package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map1 = createMap();
        int names = getCountTheSameLastName(map1, "Корнев");
        int lnames = getCountTheSameFirstName(map1, "Захар");
        System.out.println(names);
        System.out.println(lnames);
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("Корнев","Влад");
        map.put("Бурносов","Дима");
        map.put("Малый","Захар");
        map.put("Потный","Чист");
        map.put("Корнев","Захар");
        map.put("Иванов","Иван");
        map.put("Сидоров","Иван");
        map.put("Чахлый", "Дрищ");
        map.put("Петров", "Колян");
        map.put("Ловцов","Кот");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int kol = 0;
        for (Map.Entry<String,String> mp : map.entrySet()) {
            String st = mp.getValue();
            if (st.equals(name)) kol =+ kol;
        }
        return kol;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        if (map.containsKey(lastName))
                return 1;
            else
                return 0;
    }
}
