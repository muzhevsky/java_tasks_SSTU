package com.muzhevsky.fighters;

public enum PunchType {
    Fist(0),
    Jump(1),
    Leg(2);
    private int value = 0;

    private PunchType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
