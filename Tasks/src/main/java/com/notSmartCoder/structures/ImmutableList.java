package com.notSmartCoder.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImmutableList implements Iterable {
    private final List<Copyable> list;
    int size = 0;

    public ImmutableList(Copyable...objects){
        list = new ArrayList<>();
        for(Copyable obj : objects)
            list.add(obj.getCopy());
        size = objects.length;
    }

    public Copyable getItem(int index){
        return list.get(index).getCopy();
    }

    public List<Copyable> getItems(){
        List<Copyable> result = new ArrayList<Copyable>();
        for(Copyable obj : list)
            result.add(obj.getCopy());

        return result;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }
}