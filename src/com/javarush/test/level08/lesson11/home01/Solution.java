package com.javarush.test.level08.lesson11.home01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. пункт 3
        Iterator<Cat> it = cats.iterator();
        while (it.hasNext()) {
            if(it.next().name.equals("Vasjan1")) {
                it.remove();
            }
        }
//        for (Cat c : cats) {
//            if (c.name.equals("Vasjan1")) {
//                cats.remove(c);
//            }
//        }


        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat("Vasjan1"));
        cats.add(new Cat("Vasjan2"));
        cats.add(new Cat("Vasjan3"));
        return cats;
    }

    public static void printCats(Set<Cat> cats)
    {
        for (Cat c : cats) {
            System.out.println(c);
        }
    }

    public static class Cat
    {
        public String name;
        Cat(String name)
        {
            this.name = name;
        }
    }
}
