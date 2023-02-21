package com.muzhesky.converter;

public class StringToIntegerHandler implements Handler<String, Integer>{
    @Override
    public Integer handle(String object) {
        return Integer.getInteger(object);
    }
}