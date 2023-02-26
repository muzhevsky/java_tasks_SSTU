package com.muzhevsky.reflection.utils;

import com.muzhevsky.reflection.utils.test.SomeClass;

public class Parent extends Entity {
    public int x;
    private int z;
    public SomeClass someClass = new SomeClass("asd");

    public Parent(){

    }
    public Parent(int x) {
        this.x = x;
    }
}
