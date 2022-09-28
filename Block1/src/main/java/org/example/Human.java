package org.example;

public class Human implements IPrintable {
    private String _name;

    private int _height;

    public Human(String name, int height){
        _name = name;
        if(height > 50)
            _height = height;
        else
            _height = 175;
    }

    public String getDataForPrinting(){

        return _name +", height: "+Integer.toString(_height);
    }
}
