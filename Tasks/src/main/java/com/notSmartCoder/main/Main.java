package com.notSmartCoder.main;

import com.notSmartCoder.structures.Copyable;
import com.notSmartCoder.structures.ImmutableList;
import com.notSmartCoder.structures.MyInteger;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        ImmutableList list = new ImmutableList(new MyInteger(Integer.valueOf(1)),new MyInteger(Integer.valueOf(6)), new MyInteger(Integer.valueOf(2)));
        for(Object obj : list)
            System.out.println(obj);
    }

    public static float sum(Number... numbers) {
        float result = 0;

        for (Number number : numbers)
            result += number.floatValue();

        return result;
    }

    public static double myPow(String x, String y) {
        return pow(parseDouble(x), parseDouble(y));
    }
}