package com.muzhevsky.reflection.utils.test;

import com.muzhevsky.reflection.utils.Entity;

public class SomeClass extends Entity {
    private String text;
    private int number;

    public SomeClass(){

    }

    public SomeClass(String text) {
        this.text = text;
    }

    public SomeClass(String text, int number) {
        this.text = text;
        this.number = number;
    }
}
