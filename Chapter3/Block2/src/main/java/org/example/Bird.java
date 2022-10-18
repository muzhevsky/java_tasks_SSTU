package org.example;

public abstract class Bird {
    private boolean isFlyable;
    private ColorRGB color;


    public abstract void sing();


    public ColorRGB getColor(){
        return color;
    }
    public boolean isFlyable(){
        return isFlyable;
    }
}
