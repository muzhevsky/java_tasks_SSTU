package com.muzhevsky.core.animals;

import com.muzhevsky.core.colors.ColorRGB;

import java.util.Random;

public class Cuckoo extends Bird {

    public Cuckoo() {
    }

    ;

    public Cuckoo(boolean isFlyable, ColorRGB color) {
        super(isFlyable, color);
    }

    @Override
    public void sing() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt() % 10 + 1; i++) {
            System.out.println("ku-ku");
        }
    }
}
