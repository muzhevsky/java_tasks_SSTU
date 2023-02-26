package com.muzhevsky.fighters;

public class LegPunch implements Punch {
    @Override
    public void doHit(Karate karate) {
        karate.doLegPunch();
    }
}
