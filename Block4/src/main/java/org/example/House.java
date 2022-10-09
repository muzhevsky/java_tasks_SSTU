package org.example;

public class House {
    private int floorAmount;

    public House(int amount) {
        if (amount > 0)
            floorAmount = amount;
        else
            floorAmount = 1;
    }

    public String toString() {
        if (floorAmount % 10 == 1 && floorAmount % 100 != 11)
            return "дом с " + Integer.toString(floorAmount) + " этажом";
        return "дом с " + Integer.toString(floorAmount) + " этажами";
    }
}