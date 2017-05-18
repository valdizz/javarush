package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int pol = 0;
        if (a>0)
            pol++;
        if (b>0)
            pol++;
        if (c>0)
            pol++;
        System.out.println("количество отрицательных чисел: "+(3-pol));
        System.out.println("количество положительных чисел: "+pol);
    }
}
