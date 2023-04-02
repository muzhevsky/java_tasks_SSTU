package com.muzhevsky.spring.utils;


import com.muzhevsky.spring.utils.annotations.Cache;

@Cache
public class Child extends Parent {
    public int x;
    private int y;

    public Child(String text) {
        super(text);
    }
}
