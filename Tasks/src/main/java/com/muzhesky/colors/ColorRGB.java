package com.muzhesky.colors;

public class ColorRGB {
    private float r, g, b;



    public ColorRGB(float r, float g, float b){
        if(r < 0 || r > 1)
            throw new IllegalArgumentException("red component is invalid");

        if(g < 0 || g > 1)
            throw new IllegalArgumentException("green component is invalid");

        if(b < 0 || b > 1)
            throw new IllegalArgumentException("blue component is invalid");

        this.r = r;
        this.g = g;
        this.b = g;
    }
    public ColorRGB(ColorRGB color){
        this(color.r,color.g,color.b);
    }

    public float getR() {
        return r;
    }

    public float getG() {
        return g;
    }

    public float getB() {
        return b;
    }

    public void setR(float r) {
        if(r < 0 || r > 1)
            throw new IllegalArgumentException("red component is invalid");

        this.r = r;
    }

    public void setG(float g) {
        if(g < 0 || g > 1)
            throw new IllegalArgumentException("green component is invalid");

        this.g = g;
    }

    public void setB(float b) {
        if(b < 0 || b > 1)
            throw new IllegalArgumentException("blue component is invalid");

        this.b = b;
    }
}
