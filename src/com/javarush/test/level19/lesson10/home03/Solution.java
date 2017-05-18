package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = reader.readLine())!=null){
            String[] strings = line.split("\\s");
            Date date = new GregorianCalendar(Integer.parseInt(strings[strings.length-1].trim()),Integer.parseInt(strings[strings.length-2].trim())-1,Integer.parseInt(strings[strings.length-3].trim())).getTime();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<strings.length-3; i++){
                sb.append(strings[i]).append(" ");
            }
            PEOPLE.add(new Person(sb.toString().trim(),date));
        }
        reader.close();
    }

}
