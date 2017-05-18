package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream inputStream = new FileInputStream(args[0]);
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        while (inputStream.available()>0) {
            int i = inputStream.read();
            //if (i>32 & i<=127)
                map.put(i, map.get(i)==null ? 1 : map.get(i)+1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println((char)(int)entry.getKey()+" "+entry.getValue());
        }
        inputStream.close();

    }
}
