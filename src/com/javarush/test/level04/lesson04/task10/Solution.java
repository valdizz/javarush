package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
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
        if (a==b & b==c)
            System.out.println(a+" "+b+" "+c);
        else
        {
            if (a == b)
                System.out.println(a + " " + b);
            if (b == c)
                System.out.println(b + " " + c);
            if (a == c)
                System.out.println(a + " " + c);
        }
    }
}