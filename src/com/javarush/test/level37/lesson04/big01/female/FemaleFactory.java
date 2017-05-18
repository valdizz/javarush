package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by V.Kornev on 21.10.16.
 */
public class FemaleFactory implements AbstractFactory
{
    public Human getPerson(int age){
        if (age <= KidGirl.MAX_AGE)
            return new KidGirl();
        else if (age>KidGirl.MAX_AGE && age<=TeenGirl.MAX_AGE)
            return new TeenGirl();
        else
            return new Woman();
    }
}
