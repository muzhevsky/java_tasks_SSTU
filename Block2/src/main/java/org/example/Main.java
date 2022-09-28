package org.example;

public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();
        // TASK 1.2.1

        Point A = new Point(1,3);
        Point B = new Point(23,8);
        Point C = new Point(5,10);
        Point D = new Point(25, 10);

        Line line1 = new Line(A,B);
        Line line2 = new Line(C,D);
        Line line3 = new Line(line1.GetStart(), line2.GetEnd());

        Line EF = new Line(new Point(3,2), new Point(-2,5));

        // TASK 1.2.2

        Human human1 = new Human(new Name("Клеопатра",null,null), 152);
        Human human2 = new Human(new Name("Александр","Сергеевич","Пушкин"), 167);
        Human human3 = new Human(new Name("Владимир","Маяковский",null), 189);

        printer.Print(human1);
        printer.Print(human2);
        printer.Print(human3);

        // TASK 1.2.3

        Human chudovIvan = new Human(new Name("Иван","Чудов",null),100);
        Human chudovPeter = new Human(new Name("Пётр","Чудов",null),120);
        Human chudovBoris = new Human(new Name("Борис","Чудов",null),130);

        chudovPeter.Father = chudovIvan;
        chudovBoris.Father = chudovPeter;

        printer.Print(chudovIvan);
        printer.Print(chudovPeter);
        printer.Print(chudovBoris);

        // TASK 1.2.4

        Employee boss = new Employee("Phil Spencer", null);
        Employee emp1 = new Employee("Todd Howard", null);

        Department XboxGames = new Department("XboxGames",boss);

        emp1.Department = XboxGames;
        boss.Department = XboxGames;

        printer.Print(boss);
        printer.Print(emp1);
    }
}