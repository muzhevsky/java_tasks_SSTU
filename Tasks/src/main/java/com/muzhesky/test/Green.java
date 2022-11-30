package com.muzhesky.test;

public class Green implements Color {
    private static Green instance;
    public static Green getInstance(){
        if(instance == null)
            instance = new Green();

        return instance;
    }
    @Override
    public Color getNext() {
        return Red.getInstance();
    }

    @Override
    public String toString() {
        return "green";
    }
}
