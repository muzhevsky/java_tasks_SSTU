package com.notSmartCoder.main;

import com.notSmartCoder.fighters.Karate;
import com.notSmartCoder.fighters.PunchType;
import com.notSmartCoder.student.*;

public class Main {
    public static void main(String[] args) {
//        Student vova = new Student("vova", new EvenMarkChecher(), 2,4,6);
//        System.out.println(vova.toString());
//
//        Undo();
//        System.out.println(vova.toString());
//
//        Redo();
//        System.out.println(vova.toString());
//
//        vova.removeMark(0);
//        System.out.println(vova.toString());
//        vova.removeMark(0);
//        System.out.println(vova.toString());
//
//        Redo();
//        System.out.println(vova.toString());

        Karate karate = new Karate("bob");
        karate.punch2Combination.add(Karate.punch2Collection.get(PunchType.Fist.getValue()));
        karate.punch2Combination.add(Karate.punch2Collection.get(PunchType.Fist.getValue()));
        karate.punch2Combination.add(Karate.punch2Collection.get(PunchType.Leg.getValue()));
        karate.punch2Combination.add(Karate.punch2Collection.get(PunchType.Jump.getValue()));

        karate.doPunch2Combination();
    }

    public static void Undo(){
        RedoHandler.addAction(UndoHandler.Undo());
    }
    public static void Redo(){
        UndoHandler.addAction(RedoHandler.Redo());
    }
}