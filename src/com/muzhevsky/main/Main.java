package com.muzhevsky.main;

import com.muzhevsky.geometry.Line;
import com.muzhevsky.reflection.utils.MsonReader;
import com.muzhevsky.reflection.utils.MsonWriter;
import com.muzhevsky.reflection.utils.MyUtils;
import com.muzhevsky.reflection.utils.Parent;
import com.muzhevsky.reflection.utils.test.SomeClass;
import com.muzhevsky.reflection.utils.test.SomeClassTests;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws Exception {
        Line a = new Line(1,2,3,4);
        Line b = new Line(5,6,7,8);
        MyUtils.lineConnector(a,b);

        System.out.println(a);
        System.out.println(b);

        SomeClass someObject = new SomeClass(null, 6);
        MyUtils.testSomeClass(someObject, SomeClassTests.class);

        List<Object> p = new ArrayList<>();
        p.add(new Parent(5));
        p.add(new Parent(6));

        MsonWriter writer = new MsonWriter();
        writer.write(p, "test.txt");
        writer.close();
        MsonReader<Parent> reader = new MsonReader<>("text.txt");
        Object o = reader.readLine();
    }
}