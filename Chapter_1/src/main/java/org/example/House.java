package org.example;

public class House {
    private int _floorAmount;

    public House(int amount){
        _floorAmount = amount;
    }

    public String getInfo(){
        if(_floorAmount %10 == 1 && _floorAmount %100!=11) return "дом с "+Integer.toString(_floorAmount)+" этажом";
        return "дом с "+Integer.toString(_floorAmount)+" этажами";
    }
}