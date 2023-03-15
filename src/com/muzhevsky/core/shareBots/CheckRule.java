package com.muzhevsky.core.shareBots;

public interface CheckRule {
    public boolean check(double prevValue, double nextValue);
}
