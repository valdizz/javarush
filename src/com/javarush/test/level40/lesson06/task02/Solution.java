package com.javarush.test.level40.lesson06.task02;

/* Принадлежность точки многоугольнику
Дан многоугольник, заданный координатами своих вершин.
Ребра многоугольника не пересекаются.
Необходимо реализовать метод isPointInPolygon(Point point, List<Point> polygon), который проверит,
принадлежит ли переданная точка многоугольнику.
*/

import java.util.ArrayList;
import java.util.List;

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        int parity = 0;
        for (int i = 0;  i < polygon.size(); i++) {
            Point o = polygon.get(i);
            Point d = (i+1==polygon.size() ? polygon.get(0) : polygon.get(i+1));
            switch (edgeType(point, o, d)) {
                case 1:
                    parity = 1 - parity;
            }
        }
        return (parity==1 ? true : false);
    }

    private static int classify(Point point, Point p1, Point p2){
        Point a = new Point(p2.x - p1.x, p2.y - p1.y);
        Point b = new Point(point.x - p1.x, point.y - p1.y);
        double sa = a.x * b.y - b.x * a.y;
        if (sa > 0.0)
            return 1; //left
        if (sa < 0.0)
            return 2; //right
        if ((a.x * b.x < 0.0) || (a.y * b.y < 0.0))
            return 3; //behind
        if ((Math.sqrt(a.x*a.x + a.y*a.y)) < (Math.sqrt(b.x*b.x + b.y*b.y)))
            return 4; //beyond
        if ((point.x == p2.x) && (point.y == p2.y))
            return 5; //origin
        if ((p1.x == p2.x) && (p1.y == p2.y))
            return 6; //destination
        return 0; //between
    }

    private static int edgeType (Point a, Point o, Point d)
    {
        switch (classify(a,o,d)) {
            case 1:
                return ((o.y<a.y)&&(a.y<=d.y)) ? 1 : 0; //crossing = 1
            case 2:
                return ((d.y<a.y)&&(a.y<=o.y)) ? 1 : 0;
            case 0:
            case 5:
            case 6:
                return 2; //touching = 2
            default:
                return 0; //inessential = 0
        }
    }

}
