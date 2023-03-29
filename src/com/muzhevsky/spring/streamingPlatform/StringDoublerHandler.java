package com.muzhevsky.spring.streamingPlatform;

public class StringDoublerHandler implements StringHandler{
    @Override
    public String handle(String data) {
        return data+data;
    }
}
