package com.muzhevsky.core.utils.test;

import com.muzhevsky.core.utils.SomeInterface;
import com.muzhevsky.core.utils.toString.Entity;
import com.muzhevsky.core.utils.toString.ToStringParameter;
import com.muzhevsky.core.utils.defaultHandling.Default;
import com.muzhevsky.core.utils.toString.ToString;
import com.muzhevsky.core.utils.annotations.Validate;

@Validate(SomeClassTests.class)
public class SomeClass extends Entity implements SomeInterface {
    @Default
    @ToString(ToStringParameter.YES)
    private String text;

    private Integer number;

    public SomeClass(){

    }
    public SomeClass(String text) {
        this.text = text;
    }

    public SomeClass(int number) {this.number = number; }

    public String getText(){
        System.out.println("GETTEXT() CALLED");
        return text;
    }
}
