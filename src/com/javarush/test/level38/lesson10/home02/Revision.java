package com.javarush.test.level38.lesson10.home02;

public @interface Revision {
    int revision();
    Date date();
    String comment() default "";
    Author[] authors() default {};
}
