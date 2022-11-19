package com.notSmartCoder.main;

import com.notSmartCoder.animals.Cat;
import com.notSmartCoder.animals.Meowable;
import com.notSmartCoder.animals.MeowAlerter;
import com.notSmartCoder.animals.MeowCounter;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("meower");
        MeowCounter meowCounter = new MeowCounter(cat);
        MeowAlerter meowAlerter = new MeowAlerter(meowCounter);
        doMeow(meowAlerter);
        doMeow(meowAlerter);
        doMeow(meowAlerter);
        System.out.println(meowCounter.getCount());
    }

    public static void doMeow(Meowable meowable){
        meowable.meow();
    }
}