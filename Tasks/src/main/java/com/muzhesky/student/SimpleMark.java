package com.muzhesky.student;

public class SimpleMark implements Mark{
    private int value;
    public SimpleMark(int value){
        this.value = value;
    }
    @Override
    public double getValue() {
        return (double)value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
}