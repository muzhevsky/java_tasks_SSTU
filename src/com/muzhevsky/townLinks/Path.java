package com.muzhevsky.townLinks;

public class Path {
    private Town destinationTown;
    private int moveCost;

    public Path(Town destinationTown) {
        this(destinationTown, 1);
    }

    public Path(Town destinationTown, int moveCost) {
        if (destinationTown != null)
            this.destinationTown = destinationTown;
        else
            throw new IllegalArgumentException("cannot create new path with destinationTown = null");
        setMoveCost(moveCost);
    }

    public void setMoveCost(int moveCost) {
        if (moveCost > 0)
            this.moveCost = moveCost;
        else
            throw new IllegalArgumentException("cannot create new path with moveCost <=0");
    }

    public int getMoveCost() {
        return moveCost;
    }

    public Town getDestinationTown() {
        return destinationTown;
    }

    public String toString() {
        return destinationTown.getName() + " " + moveCost;
    }
}
