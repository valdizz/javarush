package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        byte[] bytes = new byte[fis1.available()+fis2.available()];
        int i = fis2.read(bytes,0,fis2.available());
        fis1.read(bytes,i,fis1.available());

        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(bytes);

        reader.close();
        fos.close();
        fis1.close();
        fis2.close();
    }
}
