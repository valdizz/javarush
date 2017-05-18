package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);
        String exp = byteArrayOutputStream.toString();
        String[] strings = exp.split("\\s");
        int res = 0;
        switch (strings[1].trim()) {
            case "+":
                res = Integer.parseInt(strings[0].trim()) + Integer.parseInt(strings[2].trim());
                break;
            case "-":
                res = Integer.parseInt(strings[0].trim()) - Integer.parseInt(strings[2].trim());
                break;
            case "*":
                res = Integer.parseInt(strings[0].trim()) * Integer.parseInt(strings[2].trim());
                break;
        }

        System.out.println(strings[0]+" "+strings[1]+" "+strings[2]+" = "+res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

