package com.muzhevsky.main;


import com.muzhevsky.spring.configs.HomeworkConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception{
        var test = new AnnotationConfigApplicationContext(HomeworkConfig.class);
        System.out.println(test.getBean(Predicate.class).test(4));
    }
}