package com.notSmartCoder.animals;

import com.notSmartCoder.animals.Cat;
import com.notSmartCoder.animals.Meowable;

public class MeowCounter implements Meowable{
    private int count;
    private Meowable meowable;
    public MeowCounter(Cat cat){
        this.meowable = cat;
    }

    public void meow(){
        meowable.meow();
        count++;
    }

    public int getCount(){
        return count;
    }
}
