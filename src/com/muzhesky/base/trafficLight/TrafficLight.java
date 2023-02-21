package com.muzhesky.trafficLight;

public class TrafficLight {
    private Color currentColor;

    public TrafficLight(Color color){
        this();
        if(currentColor != null)
            currentColor = color;
    }

    public TrafficLight(){
        currentColor = Color.BLACK;
    }

    public String next() {
        String result = currentColor.toString();
        currentColor = currentColor.next();

        return result;
    }

    public void turnOn() {
        currentColor = Color.GREEN;
    }

    public void turnOff() {
        currentColor = Color.BLACK;
    }
}