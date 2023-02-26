package com.muzhevsky.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Polyline implements Measurable, PolylineConvertable {
    private ArrayList<Point> points;

    public Polyline() {
        points = new ArrayList<Point>();
    }

    public Polyline(Point... points) {
        this();
        setPoints(points);
    }


    public void setPoints(Point... points) {
        if (points == null)
            throw new IllegalArgumentException("points is null");

        this.points = new ArrayList<Point>(Arrays.asList(Arrays.copyOf(points, points.length)));
    }


    public void addPoints(Point... points) {
        if (points == null)
            throw new IllegalArgumentException("points is null");

        for (Point point : points) {
            if (point != null)
                this.points.add(new Point(point));
        }
    }

    public void addPoints(Polyline polyline) {
        if (polyline == null)
            throw new IllegalArgumentException("polyline is null");

        for (Point point : polyline.getPoints()) {
            if (point != null)
                this.points.add(new Point(point));
        }
    }

    public ArrayList<Point> getPoints() {
        return new ArrayList<Point>(points);
    }

    public double length() {
        double result = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            result += Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
        }

        return result;
    }

    public Polyline getPolyline() {
        return this;
    }

    public String toString() {
        String pointsString = "";
        for (Point point : points) {
            pointsString += point.toString() + " ";
        }

        return "Line { points = " + pointsString + " }";
    }

    public Polyline(Polyline line) {
        this();
        for (Point point : line.points) {
            this.points.add(new Point(point));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Polyline)) return false;
        Polyline polyline = (Polyline) o;
        return Objects.equals(points, polyline.points);
    }

    @Override
    public Polyline clone() {
        return new Polyline(this);
    }
}
