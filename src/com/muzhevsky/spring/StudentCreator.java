package com.muzhevsky.spring;

import com.muzhevsky.core.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;


//@Component
public class StudentCreator {


    private Predicate<Integer> range;

    public StudentCreator(){

    }
    @Autowired
    @Qualifier("predicate")
    public void setRange(Predicate<Integer> range){
        if (range == null) throw new IllegalArgumentException();
        this.range = range;
    }

    public Student GetStudent(String name){
        var student = new Student(name);
        student.setMarkChecker(range);
        return student;
    }
    public Student GetStudent(String name, int...marks){
        var student = new Student(name);
        student.setMarkChecker(range);
        student.addMarks(marks);
        return student;
    }
}
