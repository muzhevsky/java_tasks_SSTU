package com.notSmartCoder.main;

import com.notSmartCoder.myMath.Fraction;
import com.notSmartCoder.geometry.Point;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        //TASK 1
        System.out.println(new java.math.BigDecimal(Float.toString(sum(7, new Fraction(11, 3), 3.21, new java.math.BigInteger("12345678912345678912")))));

        //TASK 2
//        System.out.println(myPow(args[0],args[1]));

        //TASK 3
        Point point = new Point(2, 5);
        java.awt.Point point1 = new java.awt.Point();

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