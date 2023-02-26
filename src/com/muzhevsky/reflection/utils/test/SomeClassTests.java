package com.muzhevsky.reflection.utils.test;

import java.lang.reflect.Field;

public abstract class SomeClassTests {
    public static void checkForNumber(SomeClass item) throws Exception{
        Field field = item.getClass().getDeclaredField("number");
        field.setAccessible(true);
        if((Integer)(field.get(item)) < 0)
            throw new ValidateException("number is not valid");
    }

    public static void checkForText(SomeClass item) throws Exception{
        Field field = item.getClass().getDeclaredField("text");
        field.setAccessible(true);
        if(field.get(item) == null)
            throw new ValidateException("text is not valid");
    }
}

