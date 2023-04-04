package com.muzhevsky.main;

import com.muzhevsky.spring.utils.test.SomeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        var ctx = new AnnotationConfigApplicationContext("com");

//        var student = (Student)ctx.getBean("defaultStudent");
//        System.out.println(student.getName());

        var someObj = (SomeClass)ctx.getBean("someObject");
        System.out.println(someObj.getRandom());
        System.out.println(someObj.getRandom());
        System.out.println(someObj.getRandom());

        System.out.println(someObj);
    }
}