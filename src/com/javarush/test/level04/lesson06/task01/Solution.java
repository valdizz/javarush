package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int i1 = Integer.parseInt(s);
        s = bf.readLine();
        int i2 = Integer.parseInt(s);
        if (i1<i2)
            System.out.println(i1);
        else
            System.out.println(i2);

    }
}