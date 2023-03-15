package com.muzhevsky.core.student.marks;

public class BinaryMarkChecker implements MarkChecker {

    @Override
    public boolean Check(int mark) {
        return mark == 0 || mark == 1;
    }

}
