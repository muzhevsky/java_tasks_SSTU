package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TASK 1.3.1
        Student vasya = new Student("vasya", 3, 4, 5);
        Student petya = new Student("petya", vasya.getMarks());
        System.out.println(vasya);
        System.out.println(petya);
        vasya.addMarks(2);
        System.out.println(vasya);
        System.out.println(petya);

        // TASK 1.3.2
//        Point a = new Point(1,5);
//        Point b = new Point(2,8);
//        Point c = new Point(5,3);
//        Point d = new Point(2,-5);
//        Point e = new Point(4,-8);
//
//        Polyline line_abc = new Polyline(a,b,c);
//        Polyline line_adec = new Polyline(a,d,e,c);
//        System.out.println(line_abc);
//        System.out.println(line_adec);
//
//        a.x = 100;
//        System.out.println(line_abc);
//        System.out.println(line_adec);

        // TASK 1.3.3
        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");
        Town e = new Town("E");
        Town f = new Town("F");

        a.addPath(b, 5);
        a.addPath(f, 1);
        a.addPath(d, 6);
        b.addPath(a, 5);
        c.addPath(b, 3);
        c.addPath(d, 4);
        d.addPath(c, 4);
        d.addPath(e, 2);
        d.addPath(a, 6);
        e.addPath(f, 2);
        f.addPath(e, 2);
        f.addPath(b, 1);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        // TASK 1.3.4

        Employee employee = new Employee("a");
        Department xboxGames = new Department("XboxGames", employee);
        Employee employee1 = new Employee("b");
        employee1.setDepartment(xboxGames);
        Employee employee2 = new Employee("c");
        employee2.setDepartment(xboxGames);

        for (Employee item : xboxGames.getAllEmpoyees()) System.out.println(item);
    }
}