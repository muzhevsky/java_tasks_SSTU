package org.example;

public class TwoPathTown extends Town{
    @Override
    public void addPath(Town linkedTown, int moveCost){
        Path newPath = new Path(linkedTown,moveCost);
        paths.add(newPath);
        if(!linkedTown.pathsContains(newPath)){
            linkedTown.addPath(this,moveCost);
        }
    }
}
