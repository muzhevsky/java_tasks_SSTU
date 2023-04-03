package com.muzhevsky.spring.utils.test;

import com.muzhevsky.spring.Config1;
import com.muzhevsky.spring.utils.SomeInterface;
import com.muzhevsky.spring.utils.annotations.Cache;
import com.muzhevsky.spring.utils.defaultHandling.DefaultConfig;
import com.muzhevsky.spring.utils.toString.Entity;
import com.muzhevsky.spring.utils.toString.ToStringParameter;
import com.muzhevsky.spring.utils.defaultHandling.Default;
import com.muzhevsky.spring.utils.toString.ToString;
import com.muzhevsky.spring.utils.annotations.Validate;

import java.util.Random;

@Validate(SomeClassTests.class)
@ToString
@Cache
public class SomeClass implements SomeInterface {
    @Default(DefaultConfig.class)
    @ToString(ToStringParameter.YES)
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
