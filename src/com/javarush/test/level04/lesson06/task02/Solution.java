package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        s = bf.readLine();
        int i3 = Integer.parseInt(s);
        s = bf.readLine();
        int i4 = Integer.parseInt(s);
        int max=i1;
        if (i1>=i2 && i1>=i3 && i1>=i4)
            max=i1;
        if (i2>=i1 && i2>=i3 && i2>=i4)
            max=i2;
        if (i3>=i1 && i3>=i2 && i3>=i4)
            max=i3;
        if (i4>=i2 && i4>=i2 && i4>=i3)
            max=i4;
        System.out.println(max);
    }
}
