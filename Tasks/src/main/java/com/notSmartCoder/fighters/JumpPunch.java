package com.notSmartCoder.fighters;

public class JumpPunch implements Punch{

    @Override
    public void doHit(Karatist karatist) {
        karatist.doJumpPunch();
    }
}
