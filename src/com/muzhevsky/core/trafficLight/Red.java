package com.muzhevsky.core.trafficLight;

public class Red implements Colorable {
    public static final Red value = new Red();

    private Red() {

    }

    @Override
    public Colorable getNext() {
        return Green.value;
    }

    @Override
    public String toString() {
        return "red";
    }
}