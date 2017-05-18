package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = file1.readLine())!=null) {
            String[] strings = line.split("\\s");
            for (int i=0; i<strings.length; i++){
                if (strings[i].length() > 6){
                    if (sb.length()>0)
                        sb.append(",");
                    sb.append(strings[i]);
                }
            }
        }
        file2.write(sb.toString());

        file1.close();
        file2.close();
    }
}
