package com.muzhevsky.student.marks;

public class DefaultMarkChecker implements MarkChecker {
    @Override
    public boolean Check(int mark) {
        return mark < 6 && mark > 1;
    }
}
