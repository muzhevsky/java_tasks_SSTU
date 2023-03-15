package com.muzhevsky.core.townLinks;

public class TwoPathTown extends Town {
    public TwoPathTown(String name) {
        super(name);
    }

    @Override
    public void addPath(Town linkedTown, int moveCost) {
        super.addPath(linkedTown, moveCost);
        if (!linkedTown.pathsContains(new Path(this, 1))) {
            linkedTown.addPath(this, moveCost);
        }
    }
}
