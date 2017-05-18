package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return new C(this.getI(),this.getJ(),this.getName());
        }

        public C(int i, int j, String name) {
            super(i, j, name);

        }
    }
}
