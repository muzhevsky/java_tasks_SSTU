package geometry;

public class Triangle extends Figure implements PolylineConvertable {
    private Point[] points = new Point[3];

    public Triangle(Point topLeftPoint, Point... points) {
        super(topLeftPoint);

        if (points.length != 3)
            throw new IllegalArgumentException("triangle needs 3 points");

        double a = getSideLength(points[0], points[1]);
        double b = getSideLength(points[1], points[2]);
        double c = getSideLength(points[2], points[0]);

        //        Можно переиспользовать линию, но стоит ли плодить лишние объекты?
//        double c = new Line(points[0], points[1]).getMagnitude();
//        double a = new Line(points[0], points[1]).getMagnitude();
//        double b = new Line(points[0], points[1]).getMagnitude();

        if (a >= b + c || b >= a + c || c >= a + b)
            throw new IllegalArgumentException("points are placed on one line");

        for (int i = 0; i < 3; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException("some points are null");

            this.points[i] = points[i];
        }
    }

    @Override
    public double getSquare() {
        double a = getSideLength(points[0], points[1]);
        double b = getSideLength(points[1], points[2]);
        double c = getSideLength(points[2], points[0]);

//        Можно переиспользовать линию, но стоит ли плодить лишние объекты?
//        double c = new Line(points[0], points[1]).getMagnitude();
//        double a = new Line(points[0], points[1]).getMagnitude();
//        double b = new Line(points[0], points[1]).getMagnitude();

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private double getSideLength(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(firstPoint.x - secondPoint.x, 2) +
                Math.pow(firstPoint.y - secondPoint.y, 2));
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(points);
    }
}
