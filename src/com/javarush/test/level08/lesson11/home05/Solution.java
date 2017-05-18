package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] schar = s.toCharArray();
        schar[0] = Character.toUpperCase(schar[0]);
        for (int i=1; i<schar.length; i++) {
            if (schar[i-1]==' '){
                schar[i] = Character.toUpperCase(schar[i]);
            }
        }

        System.out.println(schar);
    }


}
