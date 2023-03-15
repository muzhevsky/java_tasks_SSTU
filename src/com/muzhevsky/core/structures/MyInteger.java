package com.muzhevsky.core.structures;

public class MyInteger implements Copyable {
    Integer value;

    public MyInteger(Integer value) {
        this.value = value;
    }

    public void identityMethod() {
        System.out.println(this.getClass().toString() + " " + value);
    }

    @Override
    public MyInteger getCopy() {
        return new MyInteger(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
