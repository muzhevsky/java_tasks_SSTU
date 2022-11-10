package com.notSmartCoder.geometry;

import java.util.ArrayList;

public class Point{
    public double x;
    public double y;
    private static ArrayList<Point> AllPoints = new ArrayList<>();
    public Point(double x, double y){
        this.x = x;
        this.y = y;

        AllPoints.add(this);
    }
    public Point(Point point){
        this(point.x, point.y);
    }

    public static Point createPoint(double x, double y){
        Point p = tryGetPoint(x,y);
        if(p != null)
            return p;

        Point newPoint = new Point(x,y);
        AllPoints.add(newPoint);
        return newPoint;
    }

    private static Point tryGetPoint(double x, double y){
        for(Point p : AllPoints)
            if(p.x == x && p.y == y)
                return p;

        return null;
    }

    @Override
    public String toString(){
        return "Point { x = "+ x +", y = "+ y +" }";
    }

}
