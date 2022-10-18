package org.example;

public class Main {
    public static void main(String[] args){

        Printer printer = new Printer();

        // TASK 1.1.1
        Point point1 = new Point(5, 6);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(-5, 6);

        printer.Print(point1);
        printer.Print(point2);
        printer.Print(point3);

        System.out.println();

        //////////////////////////////////////////////////////////
        // TASK 1.1.2

        Human bill = new Human("Bill Gates",180);
        Human mark = new Human("Mark Zuckerberg",190);
        Human jensen = new Human("Jensen Huang",150);

        printer.Print(bill);
        printer.Print(mark);
        printer.Print(jensen);

        System.out.println();

        //////////////////////////////////////////////////////////
        // TASK 1.1.3

        Name name1 = new Name("Клеопатра", null, "");
        Name name2 = new Name("Александр", "Пушкин", "Сергеевич");
        Name name3 = new Name("Владимир", "Маяковский", "");

        printer.Print(name1);
        printer.Print(name2);
        printer.Print(name3);

        System.out.println();

        //////////////////////////////////////////////////////////
        // TASK 1.1.4

        Time time1 = new Time(10);
        Time time2 = new Time(10000);
        Time time3 = new Time(100000);

        printer.Print(time1);
        printer.Print(time2);
        printer.Print(time3);

        System.out.println();

        //////////////////////////////////////////////////////////
        // TASK 1.1.5

        House house1 = new House(100);
        House house2 = new House(21);
        House house3 = new House(111);

        printer.Print(house1);
        printer.Print(house2);
        printer.Print(house3);
    }
}