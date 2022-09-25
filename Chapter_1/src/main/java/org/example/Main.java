package org.example;

public class Main {
    public static void main(String[] args){

        // TASK 1.1.1
        Point point1 = new Point(5, 6);
        System.out.println(point1.getInfo());

        Point point2 = new Point(0, 0);
        System.out.println(point2.getInfo());

        Point point3 = new Point(-5, 6);
        System.out.println(point3.getInfo());

        System.out.println();
        
        //////////////////////////////////////////////////////////
        // TASK 1.1.2

        Human bill = new Human("Bill Gates",180);
        System.out.println(bill.getInfo());

        Human mark = new Human("Mark Zuckerberg",190);
        System.out.println(mark.getInfo());

        Human jensen = new Human("Jensen Huang",150);
        System.out.println(jensen.getInfo());

        System.out.println();

        //////////////////////////////////////////////////////////
        // TASK 1.1.3

        Name name1 = new Name("Клеопатра", null, "");
        System.out.println(name1.getInfo());

        Name name2 = new Name("Александр", "Пушкин", "Сергеевич");
        System.out.println(name2.getInfo());

        Name name3 = new Name("Владимир", "Маяковский", "");
        System.out.println(name3.getInfo());

        System.out.println();

        //////////////////////////////////////////////////////////
        // TASK 1.1.4

        Time time1 = new Time(10);
        System.out.println(time1.getFormattedTime());

        Time time2 = new Time(10000);
        System.out.println(time2.getFormattedTime());

        Time time3 = new Time(100000);
        System.out.println(time3.getFormattedTime());

        System.out.println();

        //////////////////////////////////////////////////////////
        // TASK 1.1.5

        House house1 = new House(100);
        System.out.println(house1.getInfo());

        House house2 = new House(21);
        System.out.println(house2.getInfo());

        House house3 = new House(111);
        System.out.println(house3.getInfo());
    }
}

