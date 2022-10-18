package org.example;

public class CycledPolyline extends Polyline{
    @Override
    public double getMagnitude(){
        Point start = points.get(0);
        Point end = points.get(points.size()-1);
        return super.getMagnitude() + Math.sqrt(Math.pow(start.x-end.x,2)+Math.pow(start.y-end.y,2));
    }
}
