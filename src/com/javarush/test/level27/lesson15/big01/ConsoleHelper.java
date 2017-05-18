package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V.Kornev on 19.05.16.
 */
public class ConsoleHelper
{
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Make your order ("+Dish.allDishesToString()+"):");
        while (true){
            String nameDish = readString();
            if (nameDish.equalsIgnoreCase("exit"))
                break;
            try
            {
                dishes.add(Dish.valueOf(nameDish));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(nameDish+" is not detected");
            }
        }
        return dishes;
    }
}
