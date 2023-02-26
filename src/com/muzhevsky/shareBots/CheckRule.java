package com.muzhevsky.shareBots;

public interface CheckRule {
    public boolean check(double prevValue, double nextValue);
}
