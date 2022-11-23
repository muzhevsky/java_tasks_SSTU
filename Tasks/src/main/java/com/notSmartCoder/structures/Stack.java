package com.notSmartCoder.structures;

import java.util.Arrays;

public class Stack<T> {
    private Object[] values = new Object[16];

    private int nextPosition;

    public void push(T t){
        if(nextPosition == values.length)
            values = Arrays.copyOf(values,values.length<<1);
        values[nextPosition++] = t;
    }

    public T pop(){
        if(nextPosition < 1)
            throw new RuntimeException("Stack is empty");


        if(nextPosition == values.length >> 1)
            values = Arrays.copyOf(values,values.length>>1);
        return (T)values[--nextPosition];
    }

    public void clear(){
        values = new Object[32];
        nextPosition = 0;
    }
}
