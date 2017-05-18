package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int i=a;
        if (a<b)
        {
            i=a;
            a=b;
            b=i;
        }
        if (b<c)
        {
            i=b;
            b=c;
            c=i;
        }
        if (a<b)
        {
            i=a;
            a=b;
            b=i;
        }
        System.out.println(a+" "+b+" "+c);
    }
}
