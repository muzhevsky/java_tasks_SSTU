package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline implements Measurable, PolylineConvertable {
    private List<Point> points;

    public Polyline(){
        points = new ArrayList<Point>();
    }

    public Polyline(Point...points){
        this();
        setPoints(points);
    }

    public void setPoints(Point...points){
        if(points == null)
            throw new IllegalArgumentException("points is null");

        this.points = new ArrayList<Point>(Arrays.asList(Arrays.copyOf(points,points.length)));
    }

    public void addPoints(Point...points){
        if(points == null)
            throw new IllegalArgumentException("points is null");

        for(Point point : points){
            if(point != null)
                this.points.add(new Point(point));
        }
    }

    public void addPoints(Polyline polyline){
        if(polyline == null)
            throw new IllegalArgumentException("polyline is null");

        for(Point point : polyline.getPoints()){
            if(point != null)
                this.points.add(new Point(point));
        }
    }

    public ArrayList<Point> getPoints(){
        return new ArrayList<Point>(points);
    }

    public double length(){
        double result = 0;

        for(int i = 0; i < points.size()-1; i++){
            Point start = points.get(i);
            Point end = points.get(i+1);
            result += Math.sqrt(Math.pow(start.x-end.x,2)+Math.pow(start.y-end.y,2));
        }

        return result;
    }

    public Polyline getPolyline(){
        return this;
    }

    public String toString(){
        String pointsString = "";
        for(Point point : points){
            pointsString += point.toString() + " ";
        }

        return "Line { points = "+pointsString + " }";
    }
}
