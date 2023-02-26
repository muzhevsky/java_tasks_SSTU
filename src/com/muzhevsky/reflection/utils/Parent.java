package com.muzhevsky.reflection.utils;

import com.muzhevsky.reflection.utils.test.SomeClass;

public class Parent extends com.muzhevsky.reflection.utils.Entity {
    private String text;
    public int testInt;
    public SomeClass someClass = new SomeClass("asd");

    public Parent() {

    }

    public Parent(String text) {
        this.text = text;
    }
}
