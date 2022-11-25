package com.muzhesky.converter;

public class IntegerWriterToConsole implements Writer<Integer> {
    @Override
    public void write(Integer object) {
        System.out.println(object);
    }
}
