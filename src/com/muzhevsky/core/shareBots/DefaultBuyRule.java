package com.muzhevsky.core.shareBots;

public class DefaultBuyRule implements CheckRule {

    @Override
    public boolean check(double prevValue, double nextValue) {
        return nextValue / prevValue <= 0.90;
    }
}
