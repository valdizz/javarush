package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fs = new FileInputStream(args[0]);
        int kolsimbols = fs.available();
        int kolprobels = 0;
        while (fs.available()>0) {
            if (fs.read()==32)
                kolprobels++;
        }

        BigDecimal res = new BigDecimal(0);
        if (kolsimbols!=0)
            res = new BigDecimal((double)kolprobels/kolsimbols*100);

        System.out.println(res.setScale(2, RoundingMode.HALF_UP).doubleValue());
        fs.close();
    }

}
