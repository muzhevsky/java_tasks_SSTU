package com.muzhevsky.main;

import com.muzhevsky.core.student.Student;
import com.muzhevsky.spring.random.MyRandom;
import com.muzhevsky.spring.utils.test.SomeClass;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        var Student1 = new Student("d", 3,4,2,2);
        var Student2 = new Student("c", 4,5,5);
        var Student3 = new Student("b", 2,5,3);
        var Student4 = new Student("a",4);
        var Student5 = new Student("a",5);


        var test = Stream.of(Student1, Student2, Student3, Student4, Student5)
                .map(student -> new AbstractMap.SimpleEntry<>(Math.floor(student.getAverageIntMark()), student))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        System.out.println(test);

        for (var item : test.keySet()){
            System.out.println(test.get(item));
        }
    }
}