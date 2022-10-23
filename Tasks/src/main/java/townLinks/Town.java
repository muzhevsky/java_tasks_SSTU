package townLinks;

import java.util.ArrayList;

public class Town {
    private String name;
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

    public Town(String name, ArrayList<Path> paths) {
        this(name);

        if(paths == null)
            throw new IllegalArgumentException("paths are null");
        this.paths = new ArrayList<Path>(paths);
    }

    public void addPath(Town linkedTown, int moveCost) {
        Path newPath = new Path(linkedTown,moveCost);
        if(!pathsContains(newPath))
            paths.add(newPath);
    }

    public void addPaths(Path...paths) {
        if (paths == null)
            throw new IllegalArgumentException("cannot add null path");

        for(Path path : paths)
            if(!pathsContains(path)){
                addPath(path.getDestinationTown(),path.getMoveCost());
            }
    }

    public void removePath(Path path){
        for(Path item : paths){
            if(path.getDestinationTown() == item.getDestinationTown())
                paths.remove(item);
        }
    }

    boolean pathsContains(Path path){
        for(Path item : paths)
            if(path.getDestinationTown() == item.getDestinationTown()) return true;

        return false;
    }

    public String getName(){
        return name;
    }

    public String toString() {
        String pathsString = "";
        for (Path item : paths) {
            pathsString += "\t " + item.toString() + "\n";
        }

        return name + ":\n" + pathsString;
    }

}