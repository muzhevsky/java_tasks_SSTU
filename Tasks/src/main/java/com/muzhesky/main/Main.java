package com.muzhesky.main;

import com.muzhesky.test.Red;
import com.muzhesky.test.TrafficLight;

public class Main {
    public static void main(String[] args) {

        TrafficLight tl = new TrafficLight(new Red());

        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
    }
}