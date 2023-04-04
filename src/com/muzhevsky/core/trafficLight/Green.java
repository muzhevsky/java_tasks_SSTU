package com.muzhevsky.core.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
