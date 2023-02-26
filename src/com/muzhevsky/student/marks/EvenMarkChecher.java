package com.muzhevsky.student.marks;

public class EvenMarkChecher implements MarkChecker {
    @Override
    public boolean Check(int mark) {
        return mark % 2 == 0;
    }
}
