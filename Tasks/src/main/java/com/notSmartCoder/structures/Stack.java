package com.notSmartCoder.structures;

import java.util.Arrays;

public class Stack<T> {
    private Object[] values = new Object[32];

    private int nextPosition;

    public void push(T t){
        if(nextPosition == values.length)
            values = Arrays.copyOf(values,values.length<<1);
        values[nextPosition++] = t;
    }

    public T pop(){
        if(nextPosition <= 1)
            throw new RuntimeException("Stack is empty");

        return (T)values[--nextPosition];
    }

}
