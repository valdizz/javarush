package com.javarush.test.level33.lesson05.home01;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/* Первая сериализация в JSON
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

1) В программе не выполнено основное требование к сериализации в JSON.
Найдите ошибку и исправьте.
2) Расставьте правильно Json аннотации у классов.
Все данные должны сериализоваться.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat ();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog ();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        House house = new House();
        house.pets.add(cat);
        house.pets.add(dog);

        StringWriter writer = new StringWriter();
        convertToJSON(writer, house);
        System.out.println(writer.toString());
        //[{"name":"Murka","age":5,"weight":3},{"name":"Killer","age":8,"owner":"Bill Jeferson"}]
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Cat.class, name = "cat"),
            @JsonSubTypes.Type(value = Dog.class, name = "dog")
    })
    @JsonAutoDetect
    public static class Pet
    {
        public String name;
    }
    @JsonAutoDetect
    public static class Cat extends Pet
    {
        public int age;
        public int weight;
    }
    @JsonAutoDetect
    public static class Dog extends Pet
    {
        public int age;
        public String owner;
    }
    @JsonAutoDetect
    public static class House
    {
        public ArrayList<Pet> pets = new ArrayList<Pet>();
    }
}
