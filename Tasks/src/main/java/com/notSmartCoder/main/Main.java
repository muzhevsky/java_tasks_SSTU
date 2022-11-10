package com.notSmartCoder.main;

import com.notSmartCoder.fighters.FistPunch;
import com.notSmartCoder.fighters.Karatist;
import com.notSmartCoder.fighters.LegPunch;
import com.notSmartCoder.fighters.JumpPunch;
import com.notSmartCoder.structures.Stack;
import com.notSmartCoder.student.*;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Student vova = new Student("vova", new EvenMarkChecher(), 2,4,6);
        System.out.println(vova.toString());

        Undo();
        System.out.println(vova.toString());

        Redo();
        System.out.println(vova.toString());

        vova.removeMark(0);
        System.out.println(vova.toString());
        vova.removeMark(0);
        System.out.println(vova.toString());

        Redo();
        System.out.println(vova.toString());
    }

    public static void Undo(){
        RedoHandler.addAction(UndoHandler.Undo());
    }
    public static void Redo(){
        UndoHandler.addAction(RedoHandler.Redo());
    }
}