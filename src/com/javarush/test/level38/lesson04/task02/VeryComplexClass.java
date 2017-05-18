package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/


public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        //напишите тут ваш код
        Object i = "55555";
        System.out.println((char)i);
    }

    public void methodThrowsNullPointerException() {
        //напишите тут ваш код
        int[] array = new int[5];
        array = null;
        int i =array.length;
    }

}
