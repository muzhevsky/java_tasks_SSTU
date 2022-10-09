package org.example;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this(start.x, start.y, end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public String toString() {
        return "Line from " + start.toString() + " to " + end.toString();
    }

    public Point GetStart() {
        return new Point(start);
    }

    public Point GetEnd() {
        return new Point(end);
    }
}