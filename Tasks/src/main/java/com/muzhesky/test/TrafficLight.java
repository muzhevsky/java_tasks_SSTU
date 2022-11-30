package com.muzhesky.test;

public class TrafficLight {
    private Color currentColor;

    public TrafficLight(Color color){
        currentColor = color;
    }

    public String next() {
        String result = currentColor.toString();
        currentColor = currentColor.getNext();

        return result;
    }

    public void turnOn() {
        currentColor = Red.getInstance();
    }

    public void turnOff() {
        currentColor = Black.getInstance();
    }
}
