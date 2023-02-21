package com.muzhesky.reflection.utils.test;

import com.muzhesky.reflection.utils.Entity;

public class SomeClass extends Entity {
    public String text;
    public int number;

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
