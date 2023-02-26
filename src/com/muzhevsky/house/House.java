package com.muzhevsky.house;

public class House {
    private int floorAmount;

    public House(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("floor amount cant be less then 0");
        floorAmount = amount;
    }

    public void setFloorAmount(int floorAmount) {
        if (floorAmount < 0)
            throw new IllegalArgumentException("floor amount cant be less then 0");
        this.floorAmount = floorAmount;
    }

    public String toString() {
        if (floorAmount % 10 == 1 && floorAmount % 100 != 11)
            return "дом с " + Integer.toString(floorAmount) + " этажом";
        return "дом с " + Integer.toString(floorAmount) + " этажами";
    }
}