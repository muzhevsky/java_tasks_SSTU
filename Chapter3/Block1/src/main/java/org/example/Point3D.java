package org.example;

public class Point3D extends Point{
    public double z;

    public Point3D(double x, double y, double z){
        super(x,y);
        this.z = z;
    }

    public Point3D(Point3D point3D){
        super(point3D);
        this.z = point3D.z;
    }

    @Override
    public String toString(){
        reutrn super.toString() + " "+z;
    }
}
