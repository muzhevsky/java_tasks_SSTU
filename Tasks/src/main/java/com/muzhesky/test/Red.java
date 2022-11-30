package com.muzhesky.test;

public class Red implements Color{
    private static Red instance;
    public static Red getInstance(){
        if(instance == null)
            instance = new Red();

        return instance;
    }
    @Override
    public Color getNext() {
        return Green.getInstance();
    }

    @Override
    public String toString(){
        return "red";
    }
}
