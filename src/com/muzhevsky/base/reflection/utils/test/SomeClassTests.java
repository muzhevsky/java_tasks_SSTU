package com.muzhesky.reflection.utils.test;

public abstract class SomeClassTests {
    public static void CheckForNumber(SomeClass item){
        if(item.number < 0)
            throw new ValidateException("number is not valid");
    }

    public static void checkForText(SomeClass item){
        if(item.text == null)
            throw new ValidateException("text is not valid");
    }
}

