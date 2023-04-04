package com.muzhevsky.core.shareBots;

public interface CheckRule {
    boolean check(double prevValue, double nextValue);
}
