package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline(){
        points = new ArrayList<Point>();
    }

    public Polyline(Point...points){
        this();
        setPoints(points);
    }

    public void setPoints(Point...points){
        if(points == null)
            throw new IllegalArgumentException("points is null");

        this.points = new ArrayList<Point>(Arrays.asList(Arrays.copyOf(points,points.length)));
    }

    public void addPoints(Point...points){
        if(points == null)
            throw new IllegalArgumentException("points is null");

        for(Point point : points){
            if(point != null)
                this.points.add(new Point(point));
        }
    }

    public double getMagnitude(){
        double result = 0;

        for(int i = 0; i < points.size()-1; i++){  // НАДО БЫ СДЕЛАТЬ ХРАНЕНИЕ ТОЧЕК МАССИВЧИКОМ НО НЕ ХОЧЕТСЯ
            Point start = points.get(i);
            Point end = points.get(i+1);
            result += Math.sqrt(Math.pow(start.x-end.x,2)+Math.pow(start.y-end.y,2));
        }

        return result;
    }

    public String toString(){
        String pointsString = "";
        for(Point point : points){
            pointsString += point.toString() + " ";
        }

        return "Line { points = "+pointsString + " }";
    }
}
