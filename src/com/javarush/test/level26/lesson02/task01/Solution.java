package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final double mediana;
        if (array.length % 2 == 0){
            mediana = (array[(int)array.length/2]+array[(int)array.length/2 - 1])/2.0;
        }
        else {
            mediana = array[(int)array.length/2];
        }
        System.out.println(mediana);
        Arrays.sort(array, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result = Double.compare(Math.abs(o1 - mediana),Math.abs(o2 - mediana));
                if (result!=0) return result;
                result = Integer.compare(o1,o2);
                return result;
            }
        });
        return array;
    }

}
