package com.muzhevsky.spring.streamingPlatform;

public class StringToUpperHandler implements StringHandler {
    @Override
    public String handle(String data) {
        return data.toUpperCase();
    }
}
