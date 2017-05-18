package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson
{

    private int course;
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade)
    {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live()
    {
        learn();
    }

    public void learn()
    {
    }

    public int getCourse()
    {
        return course;
    }

    public void incAverageGrade(double delta)
    {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setCourse(int course)
    {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade)
    {
        this.averageGrade = averageGrade;
    }

    @Override
    public String getPosition()
    {
        return "Студент";
    }

    public void setBeginningOfSession(Date date)
    {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date)
    {
        endOfSession = date;
    }

    public double getAverageGrade()
    {
        return averageGrade;
    }
}