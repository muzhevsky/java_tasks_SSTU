package com.notSmartCoder.geometry;

public class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point topLeftPoint, Point center, double radius) {
        super(topLeftPoint);
        if (center == null)
            throw new IllegalArgumentException("center point is null");
        this.center = new Point(center);

        if (radius <= 0)
            throw new IllegalArgumentException("radius cannot be less then zero");
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }
}
