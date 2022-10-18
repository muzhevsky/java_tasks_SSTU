package org.example;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(Point point){
        this(point.x, point.y);
    }

    public String toString(){
        return "Point { x = "+ x +", y = "+ y +" }";
    }
}
