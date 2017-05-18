package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        String st, str="";
        while ((st = bufferedReader.readLine())!=null){
            str += st + " ";
        }
        String[] strings = str.split("\\s");
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        Set<String> set = new HashSet<>();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            iterator.remove();
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            if (list.contains(sb.toString())){
                set.add(s);

            }
        }
        for (String s : set){
            Pair p = new Pair();
            p.first = s;
            StringBuilder sb = new StringBuilder(s).reverse();
            p.second = sb.toString();
            result.add(p);
        }
        for (Pair pair : result){
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
