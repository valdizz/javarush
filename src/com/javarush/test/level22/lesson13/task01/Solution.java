package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(query,delimiter);
        while (st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        String[] strings = new String[list.size()];
        list.toArray(strings);

        return strings;
    }
}
