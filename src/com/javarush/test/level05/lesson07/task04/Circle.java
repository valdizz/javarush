package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    public int x ,y, r, w;
    public String color;

    public void initialize(int x, int y, int r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void initialize(int x, int y, int r, int w)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.w = w;
    }

    public void initialize(int x, int y, int r, int w, String color)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.w = w;
        this.color = color;
    }
}
