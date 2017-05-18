package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String,Cat> map = new HashMap<String, Cat>();
        map.put("aaa1",new Cat("aaa1"));
        map.put("aaa2",new Cat("aaa2"));
        map.put("aaa3",new Cat("aaa3"));
        map.put("aaa4",new Cat("aaa4"));
        map.put("aaa5",new Cat("aaa5"));
        map.put("aaa6",new Cat("aaa6"));
        map.put("aaa7",new Cat("aaa7"));
        map.put("aaa8",new Cat("aaa8"));
        map.put("aaa9",new Cat("aaa9"));
        map.put("aaa10",new Cat("aaa10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String,Cat> entry : map.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
