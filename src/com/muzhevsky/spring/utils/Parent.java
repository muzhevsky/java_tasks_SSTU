package com.muzhevsky.spring.utils;

import com.muzhevsky.spring.utils.toString.Entity;
import com.muzhevsky.spring.utils.test.SomeClass;

public class Parent extends Entity {
    private String text;
    public int testInt;
    public SomeClass someClass = new SomeClass("asd");

    public Parent() {

    }

    public Parent(String text) {
        this.text = text;
    }
}
