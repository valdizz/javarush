package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Arrays;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int[] result = null;
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        int count1 = 1;

        //инициализация массива для степеней
        int len = (N+"").length();
        int[][] mas = new int[10][len+2];
        for (int x=0; x<10; x++)
            for (int y=1; y<len+2; y++){
                mas[x][y] = (int)Math.pow(x,y);
            }

        for (int i=1; i<=N; i++){
            //проверка на последовательные числа
            boolean isOneDigit = true;
            char m[] = (i+"").toCharArray();
            for (int k=0; k<m.length-1; k++){
                int a = m[k]==48 ? 59 : m[k];
                int b = m[k+1]==48 ? 59 : m[k+1];
                if (a > b) {
                    isOneDigit = false;
                    break;
                }
            }

            if (isOneDigit)
            {
                count++;
                //ищем сумму
                long sum = 0;
                int M = (i+"").length();
                char[] mm = (i+"").toCharArray();
                for (int k=0; k<mm.length; k++)
                    sum += mas[Character.getNumericValue(mm[k])][M];

                //првоеряем сумму на число Армстронга
                if (sum <= N && !list.contains((int)sum))
                {
                    count1++;
                    int total = 0;
                    M = (sum + "").length();
                    char[] mmm = (sum + "").toCharArray();
                    for (int k = 0; k < mmm.length; k++)
                    {
                        total += mas[Character.getNumericValue(mmm[k])][M];
                    }
                    if (total == sum)
                        list.add((int) sum);
                }
            }
        }

        result = new int[list.size()];
        for (int h=0; h<list.size(); h++){
            result[h] = list.get(h);
        }
        Arrays.sort(result);
        System.out.println(count);
        System.out.println(count1);
        return result;
    }

    public static void main(String[] args){
        long a=System.currentTimeMillis();
        int[] res = getNumbers(146511208);
        long b=System.currentTimeMillis();
        System.out.println("time seconds "+(b-a)/1000);
        System.out.println("memory "+(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory())/1024/1024 + " mb");
        for (int i=0; i<res.length; i++)
            System.out.println(res[i]);
    }
}

