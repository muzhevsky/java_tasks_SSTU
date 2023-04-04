package com.muzhevsky.spring.utils.test;


import com.muzhevsky.spring.cache.Cache;

@Cache
public class Child extends Parent {
    public int x;
    private int y;

    public Child(String text) {
        super(text);
    }
}
