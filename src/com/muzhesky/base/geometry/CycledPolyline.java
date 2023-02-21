package com.muzhesky.geometry;

import java.util.List;

public class CycledPolyline extends Polyline{
    public CycledPolyline(Point...points){
        super(points);
    }
    @Override
    public double length(){
        List<Point> points = getPoints();
        Point start = points.get(0);
        Point end = points.get(points.size()-1);
        return super.length() + Math.sqrt(Math.pow(start.x-end.x,2)+Math.pow(start.y-end.y,2));
    }
}
