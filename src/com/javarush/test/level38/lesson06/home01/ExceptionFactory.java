package com.javarush.test.level38.lesson06.home01;

/**
 * Created by V.Kornev on 27.10.16.
 */
public class ExceptionFactory
{
    public static Throwable  getFactoryClass(Enum en) {
        if (en==null)
            return new IllegalArgumentException();
        String msg = en.name().substring(0,1)+en.name().substring(1).toLowerCase().replaceAll("_"," ");
        if (en==ExceptionApplicationMessage.SOCKET_IS_CLOSED || en==ExceptionApplicationMessage.UNHANDLED_EXCEPTION)
            return new Exception(msg);
        else if (en==ExceptionDBMessage.NOT_ENOUGH_CONNECTIONS || en==ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT)
            return new RuntimeException(msg);
        else if (en==ExceptionUserMessage.USER_DOES_NOT_EXIST || en==ExceptionUserMessage.USER_DOES_NOT_HAVE_PERMISSIONS)
            return new Error(msg);
        else
            return new IllegalArgumentException();
    }
}
