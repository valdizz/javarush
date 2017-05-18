package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    public int t,l,w,h;

    public void initialize(int l, int t, int w, int h)
    {
        this.l = l;
        this.t = t;
        this.w = w;
        this.h = h;
    }

    public void initialize(int l, int t)
    {
        this.l = l;
        this.t = t;
        this.w = 0;
        this.h = 0;
    }

    public void initialize(int l, int t, int w)
    {
        this.l = l;
        this.t = t;
        this.w = w;
        this.h = w;
    }

    public void initialize(Rectangle rect2)
    {
        this.l = rect2.l;
        this.t = rect2.t;
        this.w = rect2.w;
        this.h = rect2.h;
    }

}
