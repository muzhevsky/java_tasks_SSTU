package com.notSmartCoder.test;

public class IntegerSenderToConsole implements Sender<Integer>{
    @Override
    public void send(Integer i) {
        System.out.println(i);
    }
}
