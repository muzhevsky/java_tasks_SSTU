package com.muzhevsky.spring;

import com.muzhevsky.core.trafficLight.Colorable;

public class NewTrafficLight implements Colorable {
    private Colorable turnOffColor;
    private Colorable turnOnColor;
    private Colorable currentColor;

    public NewTrafficLight(Colorable offColor, Colorable turnOnColor){
        this.turnOffColor = offColor;
        this.currentColor = offColor;
        this.turnOnColor = turnOnColor;
    }

    public void turnOn(){
        if (currentColor != turnOffColor) return;
        currentColor = turnOnColor;
    }

    public void turnOff(){
        if (currentColor == turnOffColor) return;
        currentColor = turnOffColor;
    }

    @Override
    public Colorable getNext() {
        currentColor = currentColor.getNext();
        return currentColor;
    }

    @Override
    public String toString(){
        return currentColor.toString();
    }
}
