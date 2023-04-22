package com.muzhevsky.main;

import com.muzhevsky.core.student.Student;
import com.muzhevsky.spring.jdbc.Employee;
import com.muzhevsky.spring.jdbc.OfficeModel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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



        var ctx = new AnnotationConfigApplicationContext("com.muzhevsky.spring");
//        var connection = (Connection)ctx.getBean("mySqlOfficeConnection");
//        Statement statement = connection.createStatement();
//        var set = statement.executeQuery("select * from employee");
//        var metadata = set.getMetaData();
//        while(set.next()){
//            for(int i = 1; i <= metadata.getColumnCount(); i++)
//                System.out.println(set.getString(i));
//        }

        var model = (OfficeModel)ctx.getBean("OfficeModel");
//        System.out.println(model.getObject(Employee.class, 1));
        System.out.println(model.getObjects(Employee.class));
    }
}