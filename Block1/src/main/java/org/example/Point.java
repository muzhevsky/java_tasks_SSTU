package org.example;

public class Point implements IPrintable {
    private int _x;
    private int _y;

    public Point(int x, int y){
        _x = x;
        _y = y;
    }

    public Point(){ }

    public String getDataForPrinting(){
        return "{"+ _x +";"+ _y +"}";
    }
}
