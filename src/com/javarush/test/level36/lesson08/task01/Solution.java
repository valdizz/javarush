package com.javarush.test.level36.lesson08.task01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> set = new TreeSet<>();
        int count = 0;

        File file = new File(args[0]);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStream.read(bytes);

        String res = new String(bytes);
        for (int i=0; i<res.length(); i++){
            String st = String.valueOf(res.charAt(i)).toLowerCase();
            if (st.matches("[a-z]"))
                set.add(st);
        }

        fileInputStream.close();

        for (String s : set){
            System.out.print(s);
            count++;
            if (count == 5)
                break;
        }
    }
}
