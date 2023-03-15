package com.muzhevsky.core.utils;

import com.muzhevsky.core.utils.test.SomeClass;

public class Parent extends com.muzhevsky.core.utils.Entity {
    private String text;
    public int testInt;
    public SomeClass someClass = new SomeClass("asd");

    public Parent() {

    }

    public Parent(String text) {
        this.text = text;
    }
}
