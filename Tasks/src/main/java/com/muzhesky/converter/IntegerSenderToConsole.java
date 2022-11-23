package com.muzhesky.converter;

public class IntegerSenderToConsole implements Sender<Integer>{
    @Override
    public void send(Integer i) {
        System.out.println(i);
    }
}
