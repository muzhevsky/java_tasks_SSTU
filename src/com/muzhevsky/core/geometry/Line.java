package com.muzhevsky.core.geometry;

import java.util.Objects;

public class Line implements Measurable, PolylineConvertable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this(start.x, start.y, end.x, end.y);
    }

    public Line(double x1, double y1, double x2, double y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    public String toString() {
        return "Line from " + start.toString() + " to " + end.toString();
    }

    public Polyline getPolyline() {
        return new Polyline(start, end);
    }

    public double length() {
        return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
    }

    public Point getStart() {
        return new Point(start);
    }

    public Point getEnd() {
        return new Point(end);
    }

    @Override
    public Object clone() {
        return new Line(start, end);
    }


    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }
}
