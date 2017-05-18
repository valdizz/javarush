package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gfName = reader.readLine();
        Cat catGF = new Cat(gfName, null, null);

        String gmName = reader.readLine();
        Cat catGM = new Cat(gmName, null, null);

        String fName = reader.readLine();
        Cat catF = new Cat(fName, catGF, null);

        String mName = reader.readLine();
        Cat catM = new Cat(mName, null, catGM);

        String sName = reader.readLine();
        Cat catS = new Cat(sName, catF, catM);

        String dName = reader.readLine();
        Cat catD = new Cat(dName, catF, catM);

        System.out.println(catGF);
        System.out.println(catGM);
        System.out.println(catF);
        System.out.println(catM);
        System.out.println(catS);
        System.out.println(catD);

    }

    public static class Cat
    {
        private String name;
        private Cat parentf;
        private Cat parentm;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parentf, Cat parentm)
        {
            this.name = name;
            if (parentf == null)
                this.parentf = null;
            else
                this.parentf = parentf;
            if (parentm == null)
                this.parentm = null;
            else
                this.parentm = parentm;
        }

        @Override
        public String toString()
        {
            String fname, mname;

            if (parentf == null)
                fname = ", no father";
            else
                fname = ", father is "+ parentf.name;

            if (parentm == null)
                mname = ", no mother";
            else
                mname = ", mother is "+ parentm.name;

            return "Cat name is " + name + mname + fname;
        }
    }

}
