package com.muzhevsky.save;

import java.util.ArrayList;
import java.util.List;

public class SaveHandler<T> {
    private List<SaveObject<T>> saves = new ArrayList<>();


    public void save(SaveObject saveObject){
        saves.add(saveObject);
    }

    public T load(int index){
        return saves.get(index).load();
    }
}