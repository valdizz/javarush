package com.javarush.test.level38.lesson10.home02;

import java.lang.annotation.Inherited;

@Inherited
public @interface Date {
    int year();
    int month();
    int day();
    int hour();
    int minute();
    int second();
}
