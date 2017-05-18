package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static volatile boolean isEnd = false;
    private static ArrayList<FileInputStream> list = new ArrayList<>();

    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            while (!isEnd)
            {
                FileInputStream fileInputStream = new FileInputStream(reader.readLine());
                if (fileInputStream.available()>=1000)
                    list.add(fileInputStream);
                else {
                    isEnd = true;
                    for (FileInputStream fileIn : list)
                        fileIn.close();
                    throw new DownloadException();

                }
            }
            reader.close();
        }
        catch (IOException e) {}

    }

    public static class DownloadException extends Exception{

    }
}
