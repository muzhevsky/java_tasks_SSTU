package org.example;

import java.util.ArrayList;

public class Town {
    public String name;
    private ArrayList<Path> paths;

    public Town() {
        name = "";
        paths = new ArrayList<Path>();
    }

    public Town(String name) {
        this();
        if (name != null)
            this.name = name;

        else
            throw new IllegalArgumentException("cannot create new town with null name");
    }

    public Town(String name, Town[] linkedTowns, int[] moveCosts) {
        this(name);

        if (linkedTowns.length != moveCosts.length)
            throw new IllegalArgumentException("towns length is not equal to moveCosts length");

        for (int i = 0; i < linkedTowns.length; i++)
            addPath(linkedTowns[i], moveCosts[i]);
    }

    public void addPath(Town linkedTown, int moveCost) {
        paths.add(new Path(linkedTown, moveCost));
    }

    public void addPath(Path path) {
        if (path != null)
            paths.add(path);
        else
            throw new IllegalArgumentException("cannot add null path");
    }

    public ArrayList<Path> getPaths() {
        return new ArrayList<Path>(paths);
    }

    public void setPath(ArrayList<Path> paths) {
        if (paths != null)
            this.paths = paths;
        else
            throw new IllegalArgumentException("cannot set new path with null value");
    }

    public String toString() {
        String pathsString = "";
        for (Path item : paths) {
            pathsString += "\t " + item.toString() + "\n";
        }

        return name + ":\n" + pathsString;
    }
}
