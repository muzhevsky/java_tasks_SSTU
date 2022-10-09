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
        if (name != null && name != "")
            this.name = name;

        else
            throw new IllegalArgumentException("cannot create new town with empty or null name");
    }
    public Town(String name, Path...paths){
        for(Path path : paths){
            ExternalLoop:
            for(Path thisPath : this.paths){
                if(thisPath == path){
                    this.paths.set(this.paths.indexOf(thisPath), path);
                    continue ExternalLoop;
                }
            }
        }
    }

    public void addPath(Town linkedTown, int moveCost) {
        if(!paths.contains(linkedTown)) // представим, что тут цикл со сравнением
            paths.add(new Path(linkedTown, moveCost));
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
