package com.notSmartCoder.main;

import com.notSmartCoder.animals.Meowable;
import com.notSmartCoder.test.Converter;
import com.notSmartCoder.test.FileStringReader;
import com.notSmartCoder.test.IntegerSenderToConsole;
import com.notSmartCoder.test.StringToIntegerHandler;

public class Main {
    public static void main(String[] args) {
        Converter<String,Integer> converter = new Converter<>();
        converter.doSomeMagic(new FileStringReader("asd"),
                              new StringToIntegerHandler(),
                              new IntegerSenderToConsole());
    }

    public static void doMeow(Meowable meowable){
        meowable.meow();
    }
}