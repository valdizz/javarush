package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(3.16, "One");
        labels.put(3.14, "Two");
        labels.put(3.12, "Tree");
        labels.put(2.16, "Four");
        labels.put(1.16, "Five");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
