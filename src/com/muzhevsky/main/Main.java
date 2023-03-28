package com.muzhevsky.main;


import com.muzhevsky.core.student.Student;
import com.muzhevsky.core.utils.CacheHandler;
import com.muzhevsky.core.utils.SomeInterface;
import com.muzhevsky.core.utils.test.SomeClass;
import com.muzhevsky.spring.NewTrafficLight;
import com.muzhevsky.spring.Review;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws Exception {
        var test = new AnnotationConfigApplicationContext("com");

        var trafficLight = (NewTrafficLight)test.getBean("trafficLight");
        System.out.println(trafficLight.toString());
        trafficLight.getNext();
        System.out.println(trafficLight.toString());
    }
}