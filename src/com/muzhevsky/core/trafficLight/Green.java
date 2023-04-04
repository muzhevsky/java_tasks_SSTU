package com.muzhevsky.core.trafficLight;

public class Green implements Colorable {
    public static Green value;

    private Green() {

    }

    @Override
    public Colorable getNext() {
        return Red.value;
    }

    @Override
    public String toString() {
        return "green";
    }
}
