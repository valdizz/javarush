package com.javarush.test.level32.lesson02.task01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
            int pos = Integer.parseInt(args[1]);
            raf.seek(pos>raf.length()?raf.length():pos);
            raf.write(args[2].getBytes());
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
