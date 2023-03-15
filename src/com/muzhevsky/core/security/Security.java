package com.muzhevsky.core.security;

public class Security {
    void check(Human human) {
        System.out.println("go away");
    }

    void check(Student student) {
        System.out.println("give your studak");
    }

    void check(Teacher teacher) {
        System.out.println("welcome");
    }
}