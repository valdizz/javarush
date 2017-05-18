package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap(){
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileInputStream input = new FileInputStream(reader.readLine());
            load(input);
        }
        catch (IOException e1){}
        catch (Exception e){}

    }

    public void save(OutputStream outputStream)  {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String,String> entry : properties.entrySet()){
            prop.setProperty(entry.getKey(),entry.getValue());

        }
        try
        {
            prop.store(outputStream, null);
            outputStream.close();
        }
        catch (IOException e){}
    }

    public void load(InputStream inputStream)
    {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        try
        {
            prop.load(inputStream);
            Enumeration<?> propertyNames = prop.propertyNames();
            while (propertyNames.hasMoreElements()){
                String key = (String) propertyNames.nextElement();
                properties.put(key, prop.getProperty(key));
            }
            inputStream.close();
        }
        catch (IOException e){}
    }
}
