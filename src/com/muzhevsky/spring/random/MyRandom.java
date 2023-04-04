package com.muzhevsky.spring.random;

import java.util.Random;

import static java.lang.Math.abs;

public class MyRandom {
    private final Random random = new Random();

    public int getRandom() {
        return abs(random.nextInt() % 101);
    }
}
