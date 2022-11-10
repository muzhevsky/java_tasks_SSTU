package com.notSmartCoder.main;

import com.notSmartCoder.fighters.FistPunch;
import com.notSmartCoder.fighters.Karatist;
import com.notSmartCoder.fighters.LegPunch;
import com.notSmartCoder.fighters.JumpPunch;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Karatist daniel = new Karatist("Daniel", new FistPunch(), new LegPunch(), new FistPunch(), new JumpPunch());
        daniel.addPunch(new FistPunch());
        daniel.doCombination();
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