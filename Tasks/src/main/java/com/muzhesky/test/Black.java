package com.muzhesky.test;

public class Black implements Color {
    private static Black instance;
    public static Black getInstance(){
        if(instance == null)
            instance = new Black();

        return instance;
    }
    @Override
    public Color getNext() {
        return this;
    }

    @Override
    public String toString() {
        return "black";
    }
}
