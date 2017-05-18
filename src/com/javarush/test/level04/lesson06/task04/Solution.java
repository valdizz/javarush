package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();
        if (s1.equals(s2))
            System.out.println("Имена идентичны");
        else {
            int l1= s1.length();
            int l2= s2.length();
            if (l1 == l2)
                System.out.println("Длины имен равны");
        }


    }
}
