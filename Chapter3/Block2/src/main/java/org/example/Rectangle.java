package org.example;

public class Rectangle extends Figure {
    private Point topLeftPoint;
    private double a, b;

    public Rectangle(Point topLeftPoint, double a, double b) {
        if (topLeftPoint == null)
            throw new IllegalArgumentException("top left point is null");

        this.topLeftPoint = new Point(topLeftPoint);
        this.a = a;
        this.b = b;
    }

    public Rectangle(Point topLeftPoint, double a) {
        this(topLeftPoint, a, a);
    }

    @Override
    public double getSquare() {
        return a * b;
    }

    public Point getTopLeftPoint() {
        return topLeftPoint;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public boolean isSquare() {
        return Math.abs(a - b) <= 10e-6;
    }
}
