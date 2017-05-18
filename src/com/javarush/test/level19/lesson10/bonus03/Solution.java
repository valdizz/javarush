package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        //BufferedReader file = new BufferedReader(new FileReader("d:\\1.txt"));
        String line;
        StringBuilder sb = new StringBuilder();
        String tag = args[0];

        Map<Integer,String> map = new TreeMap<Integer,String>();

        while ((line = file.readLine()) != null){ sb.append(line); }

        //System.out.println(sb.toString());

        Pattern p= Pattern.compile("</?"+tag);
        Matcher m = p.matcher(sb);

        while (m.find()){
            map.put(m.start(),m.group());
        }

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            if (entry.getValue().equals("<" + tag))
            {
                int begin = entry.getKey();
                // map.remove(begin);
                int kol = 1;
                for (Map.Entry<Integer, String> entry1 : map.entrySet())
                {
                    if (entry1.getKey() > begin)
                    {
                        if (entry1.getValue().equals("<" + tag))
                            kol++;
                        else
                            kol--;
                        if (kol == 0)
                        {
                            System.out.println(sb.substring(begin, entry1.getKey() + 3 + tag.length()));
                            break;
                        }
                    }
                }
            }
        }
        reader.close();
        file.close();
    }
}
