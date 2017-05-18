package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by V.Kornev on 13.05.16.
 */
public final class CurrencyManipulatorFactory
{
    public static Map<String,CurrencyManipulator> manipulatorMap = new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (!manipulatorMap.containsKey(currencyCode))
            manipulatorMap.put(currencyCode,new CurrencyManipulator(currencyCode));
        return manipulatorMap.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulatorMap.values();
    }

}
