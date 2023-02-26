package com.muzhevsky.trafficLight;

public class Black implements Colorable {
    public static final Black value = new Black();


    private Black(){

    }

    @Override
    public Colorable getNext() {
        return this;
    }

    @Override
    public String toString() {
        return "black";
    }
}
