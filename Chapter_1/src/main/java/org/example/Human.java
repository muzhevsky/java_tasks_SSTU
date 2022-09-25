package org.example;

public class Human {
    public String Name;

    public int Height;

    public Human(String name, int height){
        Name = name;
        if(height > 50)
            Height = height;
        else
            Height = 175;
    }

    public String getInfo(){
        return Name+", height: "+Integer.toString(Height);
    }
}
