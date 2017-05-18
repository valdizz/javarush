package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        String line;
        List<String> list1 = new ArrayList<>();
        while ((line = file1.readLine())!=null){
            list1.add(line);
        }
        List<String> list2 = new ArrayList<>();
        while ((line = file2.readLine())!=null){
            list2.add(line);
        }

        int j=0;
        int i=0;
        while (i<list2.size() & j<list1.size()){
            if (list2.get(i).equals(list1.get(j)))
            {
                lines.add(new LineItem(Type.SAME, list2.get(i)));
                j++;
                i++;
            }
            else if (list2.get(i+1).equals(list1.get(j)) & (i<list2.size()-1))
            {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
                i++;
            }
            else if (list2.get(i).equals(list1.get(j+1)) & (j<list1.size()-1))
            {
                lines.add(new LineItem(Type.REMOVED, list1.get(j)));
                j++;
            }
        }
        if (j<list1.size())
            lines.add(new LineItem(Type.REMOVED, list1.get(j)));
        if (i<list2.size())
            lines.add(new LineItem(Type.ADDED, list2.get(i)));

        for (LineItem li : lines){
            System.out.println(li.type+" "+li.line);
        }

        reader.close();
        file1.close();
        file2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
