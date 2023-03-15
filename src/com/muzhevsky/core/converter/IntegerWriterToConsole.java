package com.muzhevsky.core.converter;

public class IntegerWriterToConsole implements Writer<Integer> {
    @Override
    public void write(Integer object) {
        System.out.println(object);
    }
}
