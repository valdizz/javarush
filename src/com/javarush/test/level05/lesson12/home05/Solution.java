package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int sum=0,i;

        while (true)
        {
            s = bf.readLine();
            if (s.equals("сумма"))
                break;
            i = Integer.parseInt(s);
            sum += i;
        }

        System.out.println(sum);
    }
}
