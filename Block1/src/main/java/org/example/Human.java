package org.example;

public class Human{
    private String name;
    private int height;

    public Human(String name, int height){
        this.name = name;
        if(height > 50)
            this.height = height;
        else
            this.height = 175;
    }

    public String toString(){

        return name +", height: "+Integer.toString(height);
    }
}
