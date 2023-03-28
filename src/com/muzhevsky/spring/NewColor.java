package com.muzhevsky.spring;

import com.muzhevsky.core.trafficLight.Colorable;

public class NewColor implements Colorable {
    private static String value;
    private static Colorable next;

    public NewColor(String value, Colorable next){
        this.value = value;
        this.next = next;
    }

    @Override
    public Colorable getNext() {
        return next;
    }

    @Override
    public String toString(){
        return value;
    }


}
