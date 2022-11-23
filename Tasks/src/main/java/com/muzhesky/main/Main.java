package com.muzhesky.main;

import com.muzhesky.animals.Meowable;
import com.muzhesky.converter.Converter;
import com.muzhesky.converter.FileStringReader;
import com.muzhesky.converter.IntegerSenderToConsole;
import com.muzhesky.converter.StringToIntegerHandler;

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