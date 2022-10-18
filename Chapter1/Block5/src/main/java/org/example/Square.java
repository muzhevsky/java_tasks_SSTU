package org.example;

public class Square {
    private Point leftTopPoint;
    private double sideSize;

    public Square(Point leftTopPoint, double sideSize){
        if(leftTopPoint == null)
            throw new IllegalArgumentException("point is null");
        if(sideSize < 0)
            throw new IllegalArgumentException("side size is less then zero");
        this.leftTopPoint = leftTopPoint;
        this.sideSize = sideSize;
    }

    public Square(double x, double y, double sideSize){
        this(new Point(x,y), sideSize);
    }

    public Polyline getPolyline(){
        Point[] points = new Point[]{
            new Point(leftTopPoint),
            new Point(leftTopPoint.x+sideSize, leftTopPoint.y),
            new Point(leftTopPoint.x, leftTopPoint.y+sideSize),
            new Point(leftTopPoint.x+sideSize, leftTopPoint.y+sideSize)
        };

        return new Polyline(points);
    }

    public String toString(){
        return "square in "+leftTopPoint+" with "+sideSize+" size";
    }
}
