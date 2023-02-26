package main;

import com.muzhevsky.geometry.Line;
import com.muzhevsky.reflection.utils.MsonReader;
import com.muzhevsky.reflection.utils.MsonWriter;
import com.muzhevsky.reflection.utils.MyUtils;
import com.muzhevsky.reflection.utils.Parent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Line a = new Line(1, 2, 3, 4);
        Line b = new Line(5, 6, 7, 8);
        MyUtils.lineConnector(a, b);

        System.out.println(a);
        System.out.println(b);

        List<Object> pList = new ArrayList<>();
        Parent p = new Parent("1251252");
        p.testInt = 12;
        pList.add(p);

        MsonWriter writer = new MsonWriter();
        writer.write(pList, "test.txt");
        writer.close();
        MsonReader<Parent> reader = new MsonReader<>("test.txt");
        Object o = reader.readLine();
        System.out.println(o);
    }
}