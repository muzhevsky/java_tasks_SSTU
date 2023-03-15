package com.muzhevsky.core.trafficLight;

public class Green implements Colorable {
    public static final Green value = new Green();

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
