package org.example;

public class House implements IPrintable {
    private int _floorAmount;

    public House(int amount){
        if (amount > 0)
            _floorAmount = amount;
        else
            _floorAmount = 1;
    }

    public String getDataForPrinting(){
        if(_floorAmount %10 == 1 && _floorAmount %100!=11) return "дом с "+Integer.toString(_floorAmount)+" этажом";
        return "дом с "+Integer.toString(_floorAmount)+" этажами";
    }
}