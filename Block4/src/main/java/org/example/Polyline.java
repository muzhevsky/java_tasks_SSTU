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
        if(points!=null){
            this.points = new ArrayList<Point>(Arrays.asList(Arrays.copyOf(points,points.length)));
        }
    }
}
