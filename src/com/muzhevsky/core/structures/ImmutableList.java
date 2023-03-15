package com.muzhevsky.core.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImmutableList<T extends Copyable> implements Iterable<T> {
    private final List<Copyable> list;
    int size = 0;

    public ImmutableList(Copyable... objects) {
        list = new ArrayList<>();
        for (Copyable obj : objects)
            list.add(obj.getCopy());
        size = objects.length;
    }

    public Copyable getItem(int index) {
        return list.get(index).getCopy();
    }

    public List<Copyable> getItems() {
        List<Copyable> result = new ArrayList<Copyable>();
        for (Copyable obj : list)
            result.add(obj.getCopy());

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        class IterOverCopyable<T extends Copyable> implements Iterator<T> {
            private final ImmutableList iterableObject;
            private int nextIndex;

            public IterOverCopyable(ImmutableList list) {
                this.iterableObject = list;
            }

            @Override
            public boolean hasNext() {
                return nextIndex < iterableObject.size;
            }

            @Override
            public T next() {
                return (T) iterableObject.getItem(nextIndex++);
            }
        }

        return new IterOverCopyable<T>(this);
    }
}