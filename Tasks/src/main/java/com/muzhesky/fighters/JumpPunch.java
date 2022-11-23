package com.muzhesky.fighters;

public class JumpPunch implements Punch{

    @Override
    public void doHit(Karate karate) {
        karate.doJumpPunch();
    }
}
