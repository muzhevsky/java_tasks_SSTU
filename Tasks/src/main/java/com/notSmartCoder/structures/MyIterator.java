package com.notSmartCoder.structures;

import java.util.Iterator;

public class MyIterator implements Iterator {
    ImmutableList iterableObject;
    int nextIndex;
    public MyIterator(ImmutableList current){
        this.iterableObject = current;
    }
    @Override
    public boolean hasNext() {
        return nextIndex < iterableObject.size;
    }

    @Override
    public Object next() {
        return iterableObject.getItem(nextIndex++);
    }
}