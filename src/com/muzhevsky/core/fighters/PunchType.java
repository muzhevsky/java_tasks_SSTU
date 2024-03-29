package com.muzhevsky.core.fighters;

public enum PunchType {
    Fist(0),
    Jump(1),
    Leg(2);
    private int value = 0;

    PunchType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
