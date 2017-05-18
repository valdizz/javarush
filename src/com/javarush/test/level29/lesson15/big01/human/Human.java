package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive
{
    private static int nextId = 0;
    private int id = nextId++;
    protected int age;
    protected String name;

    public class Size {
        public int  height, weight;
    }

    protected Size size;

    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    public void setBloodGroup(BloodGroup bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup()
    {
        return bloodGroup;
    }

    public Human(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public List<Human> getChildren()
    {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child)
    {
        children.add(child);
    }

    public void removeChild(Human child)
    {
        children.remove(child);
    }

    public String getPosition()
    {
        return "Человек";
    }

    public void printData()
    {
        System.out.println(getPosition() + ": " + name);
    }

    @Override
    public void live()
    {

    }

    public void printSize()
    {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

}
