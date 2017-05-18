package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String st;
        int kol = 0;

        while ((st = file.readLine())!=null) {
            String[] strings = st.split("\\W");
            for (int i=0; i<strings.length; i++){
                if (strings[i].trim().equals("world"))
                    kol++;
            }
        }

        System.out.println(kol);
        reader.close();
        file.close();
    }
}
