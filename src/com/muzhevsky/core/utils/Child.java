package com.muzhevsky.core.utils;


import com.muzhevsky.core.utils.annotations.Cache;

@Cache
public class Child extends Parent {
    public int x;
    private int y;

    public Child(String text) {
        super(text);
    }
}
