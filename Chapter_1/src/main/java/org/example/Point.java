package org.example;

public class Point {
    public int X;
    public int Y;

    public Point(int x, int y){
        X = x;
        Y = y;
    }

    public Point(){ }

    public String getInfo(){
        return "{"+X+";"+Y+"}";
    }
}
