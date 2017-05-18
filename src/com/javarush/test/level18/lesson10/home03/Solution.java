package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileOutputStream fos = new FileOutputStream(file1,true);
        FileInputStream fis2 = new FileInputStream(file2);
        FileInputStream fis3 = new FileInputStream(file3);
        byte[] buf = new byte[fis2.available()+fis3.available()];
        int readbytes = fis2.read(buf,0,fis2.available());
        fis3.read(buf,readbytes,fis3.available());
        fos.write(buf);
        reader.close();
        fos.close();
        fis2.close();
        fis3.close();
    }
}
