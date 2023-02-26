package com.muzhevsky.student.marks;

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