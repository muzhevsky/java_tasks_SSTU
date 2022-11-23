package com.muzhesky.student;

public class BinaryMarkChecker implements MarkChecker{

    @Override
    public boolean Check(int mark) {
        return mark == 0 || mark == 1;
    }
}
