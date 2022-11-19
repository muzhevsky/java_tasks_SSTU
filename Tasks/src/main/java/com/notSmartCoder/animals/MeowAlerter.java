package com.notSmartCoder.animals;

public class MeowAlerter implements Meowable {

    Meowable meowable;

    public MeowAlerter(Meowable meowable) {
        this.meowable = meowable;
    }

    @Override
    public void meow() {
        System.out.println("NOW IM GONNA DO IT");
        meowable.meow();
    }
}
