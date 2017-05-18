package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name, surname;
        int age, height, weight, straight;

        Human()
        {
        }

        ;

        Human(String name)
        {
            this.name = name;
        }

        Human(String name, String surname)
        {
            this.name = name;
            this.surname = surname;
        }

        Human(String name, String surname, int age)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        Human(String name, String surname, int age, int height)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.height = height;
        }

        Human(String name, String surname, int age, int height, int weight)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        Human(String name, String surname, int age, int height, int weight, int straight)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.straight = straight;
        }

        Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        Human(int age)
        {
            this.age = age;
        }

        Human(int age, int height)
        {
            this.age = age;
            this.height = height;
        }
    }
}
