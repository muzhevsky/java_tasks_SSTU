package geometry;

public abstract class Figure {
    private Point topLeftPoint;
    public Figure(Point topLeftPoint){
        if(topLeftPoint == null)
            throw new IllegalArgumentException("top left point is null");

        this.topLeftPoint = topLeftPoint;
    }

    public Point getTopLeftPoint(){
        return topLeftPoint;
    }
    public void setTopLeftPoint(Point topLeftPoint){
        if(topLeftPoint == null)
            throw new IllegalArgumentException("top left point is null");

        this.topLeftPoint = topLeftPoint;
    }
    public abstract double getSquare();
}