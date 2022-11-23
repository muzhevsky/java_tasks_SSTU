package com.notSmartCoder.test;

public class StringToIntegerHandler implements Handler<String, Integer>{
    @Override
    public Integer handle(String object) {
        return Integer.getInteger(object);
    }
}