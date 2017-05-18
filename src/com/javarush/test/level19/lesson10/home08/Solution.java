package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String line;
        while ((line = file.readLine())!=null){
            System.out.println(replaceFirst(line));
        }
        reader.close();
        file.close();
    }

    public static String replaceFirst(String st){
        StringBuffer sb = new StringBuffer();
        for (int i=st.length()-1; i>=0; i--)
            sb.append(st.charAt(i));
        return sb.toString();
    }
}

