package com.notSmartCoder.geometry;

public class Square implements PolylineConvertable {
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

    public void setSideSize(int newSize){
        if(newSize < 0)
            throw new IllegalArgumentException("size cannot be less then 0");
        sideSize = newSize;
    }
    public double getSideSize(){
        return sideSize;
    }

    public Polyline getPolyline(){
        Point[] points = new Point[]{
            new Point(leftTopPoint),
            new Point(leftTopPoint.x+sideSize, leftTopPoint.y),
            new Point(leftTopPoint.x+sideSize, leftTopPoint.y+sideSize),
            new Point(leftTopPoint.x, leftTopPoint.y+sideSize)
        };

        return new CycledPolyline(points);
    }

    public String toString(){
        return "square in "+leftTopPoint+" with "+sideSize+" size";
    }
}
