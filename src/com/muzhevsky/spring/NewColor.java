package com.muzhevsky.spring;

import com.muzhevsky.core.trafficLight.Colorable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class NewColor implements Colorable {
    private String value;
    private Colorable next;

    public NewColor(String value, Colorable next){
        this.value = value;
        this.next = next;
    }

    public void setNext(Colorable next){
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
