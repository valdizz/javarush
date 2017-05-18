package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {


    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (!params.isEmpty())
        {
            for (Map.Entry<String, String> entry : params.entrySet())
            {
                if (entry.getValue() != null)
                {
                    sb.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
                }
            }
            if (sb.length()>5)
                sb.replace(sb.length() - 5, sb.length(), "");
        }
        return sb;
    }

}
