package com.muzhevsky.spring;

import com.muzhevsky.core.trafficLight.Color;
import com.muzhevsky.core.trafficLight.Colorable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewTrafficLight implements Colorable {
    private Colorable value;

    @Autowired
    public NewTrafficLight(@Qualifier("black") Colorable value){
        this.value = value;
    }
    @Override
    public Colorable getNext() {
        value = value.getNext();
        return value;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
