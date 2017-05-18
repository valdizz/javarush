package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        String st = new String(bytes,"UTF-8");
        FileOutputStream fos = new FileOutputStream(args[1]);
        fos.write(st.getBytes("Windows-1251"));
        stream.close();
        fos.close();
    }
}
