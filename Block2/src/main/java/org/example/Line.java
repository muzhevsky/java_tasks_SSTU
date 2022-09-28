package org.example;

public class Line {
    Point _start;
    Point _end;

    public Line(Point start, Point end){
        _start = start;
        _end = end;
    }

    public String toString(){
        return "Line from "+_start.toString()+" to "+_end.toString();
    }

    public Point GetStart(){ return _start;}
    public Point GetEnd(){ return _end;}
}
