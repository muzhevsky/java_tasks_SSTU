package org.example;

public class Line {
    Point start;
    Point end;

    public Line(Point start, Point end){
        this.start = start;
        this.end = end;
    }

    public String toString(){
        return "Line from "+ start.toString()+" to "+ end.toString();
    }

    public Point GetStart(){ return start;}
    public Point GetEnd(){ return end;}
}
