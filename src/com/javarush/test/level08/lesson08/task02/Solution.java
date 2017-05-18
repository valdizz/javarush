package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Random;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    static Random rnd = new Random();
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> hs = new HashSet<Integer>();
        while (hs.size()<20) {
            hs.add(rnd.nextInt(50));
        }
//        for (int i=1; i<=20; i++) {hs.add(i);}

        return hs;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            if (it.next() > 10) {it.remove();}
        }
        return set;
    }

    HashSet<Integer> haset = createSet();
    HashSet<Integer> haset10 = removeAllNumbersMoreThan10(haset);

}
