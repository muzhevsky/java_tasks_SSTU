package com.muzhesky.student;

public class EvenMarkChecher implements MarkChecker{
    @Override
    public boolean Check(int mark) {
        return mark % 2 == 0;
    }
}
