package org.example;

public class House {
    public int FloorNumber;

    public String getInfo(){
        if(FloorNumber%10 == 1 && FloorNumber%100!=11) return "дом с "+Integer.toString(FloorNumber)+" этажом";
        return "дом с "+Integer.toString(FloorNumber)+" этажами";
    }
}