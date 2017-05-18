package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int a = Integer.parseInt(s);
        s = bf.readLine();
        int b = Integer.parseInt(s);
        s = bf.readLine();
        int c = Integer.parseInt(s);
        int x = a;
        if (b<a)
        {
            x = b;
            b = a;
            a = x;
        }
        if (c<b)
        {
            x = c;
            c = b;
            b = x;
        }
        if (b<a)
        {
            x = b;
            b = a;
            a = x;
        }
        System.out.println(b);
    }
}
