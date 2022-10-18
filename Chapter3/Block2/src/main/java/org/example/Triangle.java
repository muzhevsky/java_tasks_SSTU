package org.example;

public class Triangle extends Figure {
    private Point[] points = new Point[3];

    public Triangle(Point... points) {
        if (points.length != 3)
            throw new IllegalArgumentException("triangle needs 3 points");

        for (int i = 0; i < 3; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException("some points are null");

            this.points[i] = points[i];
        }
    }

    @Override
    public double getSquare() {
        double a = getSideLength(0, 1);
        double b = getSideLength(1, 2);
        double c = getSideLength(2, 0);

        double p = (a + b + c) / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    private double getSideLength(int firstPointIndex, int secondPointIndex) {
        return Math.sqrt(Math.pow(points[firstPointIndex].x - points[secondPointIndex].x, 2) +
                Math.pow(points[firstPointIndex].y - points[secondPointIndex].y, 2));
    }
}
