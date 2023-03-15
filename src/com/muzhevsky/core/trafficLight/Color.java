package com.muzhevsky.core.trafficLight;

public class Color {
    private final String value;
    private Color next;

    public static final Color RED;
    public static final Color GREEN;
    public static final Color BLACK;

    static {
        RED = new Color("red");
        GREEN = new Color("green");
        BLACK = new Color("black");

        BLACK.next = BLACK;
        RED.next = GREEN;
        GREEN.next = RED;
    }

    private Color(String value) {
        this.value = value;
    }

    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return value;
    }
}