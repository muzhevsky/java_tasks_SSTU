package com.muzhevsky.spring.utils.test;

import com.muzhevsky.spring.cache.Cache;
import com.muzhevsky.spring.defaultHandling.DefaultConfig;
import com.muzhevsky.spring.defaultHandling.Default;
import com.muzhevsky.spring.toString.ToString;
import com.muzhevsky.spring.utils.annotations.Validate;

import java.util.Random;

@Validate(SomeClassTests.class)
@Cache
public class SomeClass implements SomeInterface {
    @Default(DefaultConfig.class)
    @ToString
    private String text;
    private Random random = new Random();
    private Integer number;

    public SomeClass(){

    }
    public SomeClass(String text) {
        this.text = text;
    }

    public SomeClass(int number) {this.number = number; }
    public SomeClass(String text, int number) {
        this(text);
        this.number = number;
    }

    @Cache
    public int getRandom(){
        return random.nextInt();
    }

    public String getText(){
        System.out.println("GETTEXT() CALLED");
        return text;
    }
}
