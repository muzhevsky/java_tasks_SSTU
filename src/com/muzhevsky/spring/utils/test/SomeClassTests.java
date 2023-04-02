package com.muzhevsky.spring.utils.test;

import com.muzhevsky.spring.utils.MyUtils;


public final class SomeClassTests {
    public static void checkForNumber(Object item) throws Exception {
        int value = MyUtils.<Integer>getValueOfNecessaryType(item, "number");

        if (value < 0) {
            throw new ValidateException("number is not valid");
        }
    }

    public static void checkForText(Object item) throws Exception {
        String text = MyUtils.<String>getValueOfNecessaryType(item, "text");

        if (text == null)
            throw new ValidateException("text is not valid");
    }
}

