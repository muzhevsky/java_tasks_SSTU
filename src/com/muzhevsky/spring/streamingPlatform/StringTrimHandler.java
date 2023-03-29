package com.muzhevsky.spring.streamingPlatform;

public class StringTrimHandler implements StringHandler{
    @Override
    public String handle(String data) {
        return data.trim();
    }
}
