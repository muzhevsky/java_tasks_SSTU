package org.example;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end){
        this.start = start;
        this.end = end;
    }
    public Line(int x1, int y1, int x2, int y2){
        this(new Point(x1,y1),new Point(x2,y2));
    }

    public String toString(){
        return "Line from "+ start.toString()+" to "+ end.toString();
    }

    public Point GetStart(){ return start;}
    public Point GetEnd(){ return end;}
}
