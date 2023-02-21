package com.muzhesky.reflection.utils;

import com.muzhesky.reflection.utils.Entity;
import com.muzhesky.reflection.utils.test.SomeClass;

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
