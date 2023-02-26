package com.muzhevsky.reflection.utils;

import java.lang.reflect.Field;
import java.util.Set;

public class Entity {
    @Override
    public final String toString() {
        return MsonHelper.serialise(this);
    }
}
