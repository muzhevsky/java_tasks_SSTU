package com.muzhesky.shareBots;

public class DefaultSellRule implements CheckRule {
    @Override
    public boolean check(double prevValue, double nextValue) {
        return nextValue / prevValue >= 1.05;
    }
}
