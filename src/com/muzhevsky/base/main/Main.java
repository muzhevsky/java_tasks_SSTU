package com.muzhesky.main;

import com.muzhesky.geometry.Line;
import com.muzhesky.reflection.utils.MsonReader;
import com.muzhesky.reflection.utils.MsonWriter;
import com.muzhesky.reflection.utils.MyUtils;
import com.muzhesky.reflection.utils.Parent;
import com.muzhesky.reflection.utils.test.SomeClass;
import com.muzhesky.reflection.utils.test.SomeClassTests;

import java.lang.reflect.Array;
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

        List<Object> objects = new ArrayList<>();
        objects.add(new Parent(6));
        objects.add(new Parent(3));
        objects.add(new Parent(2));
        objects.add(new Parent(11));

        MsonWriter msonWriter = new MsonWriter();
        msonWriter.write(objects, "test.txt");
        msonWriter.close();

        MsonReader<Parent> msonReader = new MsonReader<>();
        Parent p = msonReader.readLine("test.txt");
    }
}