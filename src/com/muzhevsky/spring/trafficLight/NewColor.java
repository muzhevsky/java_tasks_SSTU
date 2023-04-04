package com.muzhevsky.spring.trafficLight;

import com.muzhevsky.core.trafficLight.Colorable;
import com.muzhevsky.spring.toString.ToString;
import com.muzhevsky.spring.toString.ToStringParameter;

public class NewColor implements Colorable {
    @ToString(ToStringParameter.YES)
    private String value;
    private Colorable next;

    public NewColor() {   // Иначе не создается через Enhancer

    }

    public NewColor(String value, Colorable next) {
        this.value = value;
        this.next = next;
    }

    public void setNext(Colorable next) {
        this.next = next;
    }

    @Override
    public Colorable getNext() {
        return next;
    }

    @Override
    public String toString() {
        return value;
    }


}
