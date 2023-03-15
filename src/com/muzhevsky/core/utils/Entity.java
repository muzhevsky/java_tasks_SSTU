package com.muzhevsky.core.utils;

public class Entity {
    @Override
    public final String toString() {
        return MsonHelper.serialise(this);
    }
}
