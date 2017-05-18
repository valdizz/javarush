package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by V.Kornev on 21.10.16.
 */
public class FactoryProducer
{
    public static enum HumanFactoryType{MALE, FEMALE}

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType){
        if (humanFactoryType == HumanFactoryType.FEMALE)
            return new FemaleFactory();
        else
            return new MaleFactory();
    }
}
