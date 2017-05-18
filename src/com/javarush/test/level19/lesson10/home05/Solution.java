package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
        String line;
        while ((line = file1.readLine())!=null) {
            String[] strings = line.split("\\s");
            for (int i=0; i<strings.length; i++){
                if (containsDigit(strings[i]))
                    file2.write(strings[i]+" ");
            }
        }

        file1.close();
        file2.close();
    }

    public static boolean containsDigit(String string){
        boolean containsDigit = false;
        for (int i=0; i<string.length(); i++){
            if (Character.isDigit(string.charAt(i))){
                containsDigit = true;
            }
        }
        return containsDigit;
    }
}
