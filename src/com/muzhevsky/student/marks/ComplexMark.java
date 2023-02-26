package com.muzhevsky.student.marks;

import java.util.ArrayList;
import java.util.List;

public class ComplexMark implements Mark {
    public List<Mark> value = new ArrayList<>();

    public ComplexMark(Mark... marks) {
        for (Mark mark : marks) {
            value.add(mark);
        }
    }

    @Override
    public double getValue() {
        double result = 0;
        for (Mark mark : value)
            result += mark.getValue();

        result /= value.size();

        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (Mark i : value)
            result += i.toString();

        return result;
    }
}
