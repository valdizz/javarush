package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader inputStream = new BufferedReader(new FileReader(file1));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(file2));
        String s = null;

        while ((s=inputStream.readLine())!=null) {
            String res = "";
            String[] ss = s.split(" ");
            for (String st : ss) {
                long i = Math.round(Double.parseDouble(st));
                res += i+" ";
            }
            outputStream.write(res+"\n");
        }

        reader.close();
        inputStream.close();
        outputStream.close();

    }
}
