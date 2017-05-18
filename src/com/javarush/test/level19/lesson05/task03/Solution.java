package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(reader.readLine()));
        String st;

        while ((st = file.readLine())!=null) {
            String[] strings = st.split("\\s");
            for (int i=0; i<strings.length; i++){
                //System.out.println(strings[i]);
                if (isDigit(strings[i].trim()))
                    file2.write(strings[i].trim()+" ");
            }
        }

        reader.close();
        file.close();
        file2.close();
    }

    public static boolean isDigit(String string)
    {
        boolean isDigit = true;
        int beginnum = 0;
        if (string.charAt(0)=='-')
            beginnum = 1;
        for (int i=beginnum; i<string.length(); i++){
            if (!Character.isDigit(string.charAt(i)))
                isDigit = false;
        }
        return isDigit;
    }
}
