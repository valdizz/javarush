package com.javarush.test.level26.lesson15.big01;


/**
 * Created by V.Kornev on 13.05.16.
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i){
        switch (i){
            case 1:
                return Operation.INFO;
            case 2:
                return Operation.DEPOSIT;
            case 3:
                return Operation.WITHDRAW;
            case 4:
                return Operation.EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
