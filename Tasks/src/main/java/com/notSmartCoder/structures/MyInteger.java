package com.notSmartCoder.structures;

public class MyInteger implements Copyable{

    Integer value;
    public MyInteger(Integer value){
        this.value = value;
    }
    @Override
    public Copyable getCopy() {
        return new MyInteger(value);
    }
}
