package org.example;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public String toString() {
        return "Point { x = " + x + ", y = " + y + " }";
    }
}
