package com.notSmartCoder.animals;

import com.notSmartCoder.colors.ColorRGB;

public abstract class Bird{
    private boolean isFlyable;
    private ColorRGB color;
    public Bird(){}
    public Bird(boolean isFlyable, ColorRGB color){
        if(color == null)
            throw new IllegalArgumentException();

        this.isFlyable = isFlyable;
        this.color = color;
    }
    public abstract void sing();
}
