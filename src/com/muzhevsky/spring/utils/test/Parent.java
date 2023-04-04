package com.muzhevsky.spring.utils.test;

import com.muzhevsky.spring.toString.Entity;

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
