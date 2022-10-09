package org.example;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end){
        this(start.x,start.y,end.x,end.y);
    }
    public Line(double x1, double y1, double x2, double y2){
        start = new Point(x1,y1);
        end = new Point(x2,y2);
    }

    public String toString(){
        return "Line from "+ start.toString()+" to "+ end.toString();
    }

    public double getMagnitude(){
        return Math.sqrt(Math.pow(start.x-end.x,2)+Math.pow(start.y-end.y,2));
    }

    public Point GetStart(){ return start;}
    public Point GetEnd(){ return end;}
}
