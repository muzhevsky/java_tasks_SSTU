package com.muzhesky.student;

import java.util.ArrayList;
import java.util.List;

public class ComplexMark implements Mark{
    public List<Mark> value = new ArrayList<>();
    @Override
    public int getValue() {
        int result = 0;
        for(Mark mark : value)
            result += mark.getValue();

        result /= value.size();

        return result;
    }
}
