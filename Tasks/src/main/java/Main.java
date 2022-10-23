import geometry.*;
import myMath.*;
import animals.*;
import townLinks.Town;
import townLinks.TwoPathTown;
import weapons.*;


public class Main {
    public static void main(String[] args) {
        // TASK 1
        System.out.println(sum(2,new Fraction(3,5),2.3));

        // TASK 2
        allBirdsSing(new Parrot("never gonna give you up, never gonna let you down, never gonna run around, desert you"), new Cuckoo(), new Sparrow());

        // TASK 3
        System.out.println(getSquareSum(new Circle(new Point(0,0),5),new Rectangle(new Point(0,0), 5,4)));

        // TASK 4
        sayMeow(new Cat("barsik"), new Dog());

        // TASK 5
        System.out.println(getLength(new Line(new Point(0,0), new Point(2,3)), new Polyline(new Point(0,0), new Point (5,6), new Point(10,20))));

        // TASK 6
        Square square = new Square(new Point (0,0), 5);
        System.out.println(square.getPolyline());

        // TASK 7
        Rectangle rectangle = new Rectangle(new Point (0,0), 10, 5);
        Triangle triangle = new Triangle(new Point (0,0), new Point(2,3), new Point(4,5));

        System.out.println(getPolylineSum(square,rectangle,triangle));

        // TASK 8
        Shooter shooter = new Shooter("Misha");
        shooter.shoot();
        shooter.weapon = new Pistol();
        shooter.shoot();
        shooter.weapon = new Rifle();
        shooter.shoot();
        shooter.weapon = null;
        shooter.shoot();

        // TASK 9

        Town a = new TwoPathTown("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new TwoPathTown("D");
        Town e = new Town("E");

        a.addPath(b,1);
        a.addPath(c, 2);
        b.addPath(c, 3);
        d.addPath(b,4);
        d.addPath(e, 5);
        e.addPath(c,6);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }

    public static Polyline getPolylineSum (PolylineConvertable...polylines){
        Polyline result = new Polyline();

        for(PolylineConvertable polyline : polylines)
            result.addPoints(polyline.getPolyline());

        return result;
    }

    public static float getLength (Measurable...measurables){
        float result = 0;

        for(Measurable measurable : measurables)
            result += measurable.length();

        return result;
    }

    public static void sayMeow(Meowable...meowables){
        for(Meowable meowable : meowables)
            meowable.meow();
    }

    public static void allBirdsSing(Bird...birds){
        for(Bird bird : birds)
            bird.sing();
    }

    public static float sum (Number...numbers){
        float result = 0;

        for(Number number : numbers)
            result += number.floatValue();

        return result;
    }

    public static float getSquareSum (Figure...figures){
        float result = 0;

        for(Figure figure : figures)
            result += figure.getSquare();

        return result;
    }
}