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

    public Point getStart(){ return new Point(start);}
    public Point getEnd(){ return new Point(end);}

    public void setStart(Point point){
        setStart(point.x, point.y);
    }
    public void setStart(double x, double y){
        start = new Point(x,y);
    }

    public void setEnd(Point point){
        setEnd(point.x, point.y);
    }
    public void setEnd(double x, double y){
        end = new Point(x,y);
    }
}
