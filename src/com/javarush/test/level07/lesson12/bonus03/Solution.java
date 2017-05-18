package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        Integer[] integerArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            integerArray[i] = new Integer(array[i]);
        }
        /*Arrays.sort(integerArray, new Comparator<Integer>()
        {
            public int compare(Integer o1, Integer o2)
            {
                return o2.intValue() - o1.intValue();
            }
        });*/
        Arrays.sort(integerArray,Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            array[i] = integerArray[i].intValue();
        }

    }
}
