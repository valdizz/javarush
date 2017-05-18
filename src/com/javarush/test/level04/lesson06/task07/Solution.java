package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int a = Integer.parseInt(s);
        s = bf.readLine();
        int b = Integer.parseInt(s);
        s = bf.readLine();
        int c = Integer.parseInt(s);
        int otl = 1;
        if (b!=a && b!=c)
            otl = 2;
        if (c!=a && c!=b)
            otl = 3;
        System.out.println(otl);
    }
}
