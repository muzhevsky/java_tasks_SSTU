package com.muzhesky.fighters;

public class LegPunch implements Punch{
    @Override
    public void doHit(Karate karate) {
        karate.doLegPunch();
    }
}
