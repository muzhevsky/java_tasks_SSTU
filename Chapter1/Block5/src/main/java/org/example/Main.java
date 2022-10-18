package org.example;

public class Main {
    public static void main(String[] args) {
        // TASK 1.5.1

        Pistol glock = new Pistol();
        for(int i = 0; i < 10; i++)
            glock.shoot();

        // TASK 1.5.2

        Cat cat = new Cat("biba");
        cat.sayMeow();
        cat.sayMeow(5);

        // TASK 1.5.3

        Line line = new Line(new Point(1,1), new Point(10,15));
        System.out.println(line.getMagnitude());

        //TASK 1.5.4

        Time time = new Time(35056);
        System.out.println(time.getHour());

        time = new Time(4532);
        System.out.println(time.getMinute());

        time = new Time(123);
        System.out.println(time.getSecond());

        // TASK 1.5.5

        Fraction frac1 = new Fraction(2,7);
        Fraction frac2 = new Fraction(3,11);

        System.out.println(frac1+"\t"+frac2);

        Fraction frac3;
        frac3 = frac1.sumWith(frac2);
        System.out.println(frac3);
        frac3 = frac1.substractWith(frac2);
        System.out.println(frac3);
        frac3 = frac1.multiplyBy(frac2);
        System.out.println(frac3);
        frac3 = frac1.divideBy(frac2);
        System.out.println(frac3);

        frac3 = frac1.sumWith(2);
        System.out.println(frac3);

        System.out.println(frac1+"\t"+frac2);

        // TASK 1.5.6

        Student student = new Student("leha",2,5,5,3);
        System.out.println(student.getAverageMark());
        System.out.println(student.isExcellent());

        Student student2 = new Student("kirooha",5,5,5);
        System.out.println(student2.getAverageMark());
        System.out.println(student2.isExcellent());

        // TASK 1.5.7

        Polyline polyline = new Polyline();
        polyline.addPoints(new Point(2,5),new Point(5,7),new Point(6,12));
        System.out.println(polyline);
        System.out.println(polyline.getMagnitude());

        // TASK 1.5.8

        Square square = new Square(5,3,23);
        Polyline polyline2 = square.getPolyline();
        System.out.println(polyline2);
    }
}