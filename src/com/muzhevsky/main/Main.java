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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        var Student1 = new Student("ivan", 3,4,2,2);
        var Student2 = new Student("nikita", 4,5,5);
        var Student3 = new Student("sergei", 2,5,3);
        var Student4 = new Student("nikolay",4);
        var Student5 = new Student("leha",5);


        var marks = new String[]{"F","D","C","B","A","S"};
        var test = Stream.of(Student1, Student2, Student3, Student4, Student5)
                .collect(Collectors.groupingBy(student -> marks[(int)(student.getAverageIntMark())], Collectors.mapping(student -> student, Collectors.toList())));


        System.out.println(test);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/office","root",""); // password requires
        Statement statement = connection.createStatement();
        var set = statement.executeQuery("select * from employee");
        var metadata = set.getMetaData();
        while(set.next()){
            for(int i = 1; i <= metadata.getColumnCount(); i++)
                System.out.println(set.getString(i));
        }
    }
}