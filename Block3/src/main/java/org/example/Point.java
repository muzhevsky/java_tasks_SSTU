package org.example;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(){ }

    public String toString(){
        return "Point { x = "+ x +", y = "+ y +" }";
    }
}
