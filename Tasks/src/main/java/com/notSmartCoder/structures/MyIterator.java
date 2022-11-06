package com.notSmartCoder.structures;

import java.util.Iterator;

public class MyIterator implements Iterator {
    ImmutableList current;
    int position;
    public MyIterator(ImmutableList current){
        this.current = current;
    }
    @Override
    public boolean hasNext() {
        return position < current.size - 1;
    }

    @Override
    public Object next() {
        return current.getItem(position++);
    }
}
