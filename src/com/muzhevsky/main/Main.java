package com.muzhevsky.main;

import com.muzhevsky.spring.random.MyRandom;
import com.muzhevsky.spring.utils.test.SomeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        var ctx = new AnnotationConfigApplicationContext("com");


        var someObj = (SomeClass) ctx.getBean("someObject");
        System.out.println(someObj.getName());
//        System.out.println(someObj.getRandom());
//        System.out.println(someObj.getRandom());
//        System.out.println(someObj.getRandom());
//
//        System.out.println(someObj);

        System.out.println(((MyRandom) ctx.getBean("random")).getRandom());
        System.out.println(((MyRandom) ctx.getBean("random")).getRandom());
        System.out.println(((MyRandom) ctx.getBean("random")).getRandom());
        System.out.println(((MyRandom) ctx.getBean("random")).getRandom());
        System.out.println(someObj.getText());
        System.out.println(someObj.getNumber());
    }
}


// Storage{
// List<String>
// put(String){}
// get()
//}