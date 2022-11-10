package com.notSmartCoder.fighters;

public class LegPunch implements Punch{
    @Override
    public void doHit(Karatist karatist) {
        karatist.doLegPunch();
    }
}
