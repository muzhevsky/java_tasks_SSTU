package com.notSmartCoder.animals;

import com.notSmartCoder.colors.ColorRGB;

public class Sparrow extends Bird {

    public Sparrow(){};
    public Sparrow(boolean isFlyable, ColorRGB color){
        super(isFlyable, color);
    }
    @Override
    public void sing() {
        System.out.println("chirick");
    }
}