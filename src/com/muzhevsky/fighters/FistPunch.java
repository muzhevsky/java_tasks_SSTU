package com.muzhevsky.fighters;

public class FistPunch implements Punch {
    @Override
    public void doHit(Karate karate) {
        karate.doFistPunch();
    }
}
