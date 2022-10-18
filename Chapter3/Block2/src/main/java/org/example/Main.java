package org.example;

public class Main {
    public static void main(String[] args) {
        Parrot parrot = new Parrot("Uh, summa-lumma, dooma-lumma, you assumin' I'm a human\n" +
                "What I gotta do to get it through to you I'm superhuman?\n" +
                "Innovative and I'm made of rubber so that anything\n" +
                "You say is ricochetin' off of me, and it'll glue to you and\n" +
                "I'm devastating, more than ever demonstrating\n" +
                "How to give a motherfuckin' audience a feeling like it's levitating\n" +
                "Never fading, and I know the haters are forever waiting\n" +
                "For the day that they can say I fell off, they'll be celebrating");

        System.out.println();
        parrot.sing();

        System.out.println();
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 4), new Point(-3, 4));
        System.out.println(triangle.getSquare());
    }
}