package com.muzhevsky.main;


import com.muzhevsky.core.shareBots.Exchange;
import com.muzhevsky.core.shareBots.Share;
import com.muzhevsky.core.shareBots.TradeBot;
import com.muzhevsky.core.student.Student;
import com.muzhevsky.spring.NewTrafficLight;
import com.muzhevsky.spring.StudentCreator;
import com.muzhevsky.spring.streamingPlatform.MyFileReader;
import com.muzhevsky.spring.streamingPlatform.MyFileWriter;
import com.muzhevsky.spring.streamingPlatform.StringConverter;
import com.muzhevsky.spring.streamingPlatform.StringHandler;
import com.muzhevsky.spring.utils.test.SomeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.muzhevsky.spring.utils.MyUtils.getAllMethods;

public class Main {
    public static void main(String[] args) throws Exception {
        var ctx = new AnnotationConfigApplicationContext("com");

        var student = (Student)ctx.getBean("defaultStudent");
        System.out.println(student.getName());

        var someObj = (SomeClass)ctx.getBean("someObject");
        System.out.println(someObj);

        System.out.println(someObj.getRandom());
        System.out.println(someObj.getRandom());
        System.out.println(someObj.getRandom());
    }
}