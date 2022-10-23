package geometry;

public class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (center == null)
            throw new IllegalArgumentException("center point is null");

        this.center = new Point(center);
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
