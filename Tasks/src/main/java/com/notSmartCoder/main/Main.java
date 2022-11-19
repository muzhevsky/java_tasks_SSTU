package com.notSmartCoder.main;

import com.notSmartCoder.student.EvenMarkChecher;
import com.notSmartCoder.student.Student;
import com.notSmartCoder.student.UndoRedoHandler;

public class Main {
    public static void main(String[] args) {
        Student vova = new Student("vova", new EvenMarkChecher(), 2,4,6);
        System.out.println(vova.toString());

        UndoRedoHandler.Undo();
        System.out.println(vova.toString());

        UndoRedoHandler.Redo();
        System.out.println(vova.toString());

        vova.removeMark(0);
        System.out.println(vova.toString());
        vova.removeMark(0);
        System.out.println(vova.toString());

        UndoRedoHandler.Undo();
        System.out.println(vova.toString());
        UndoRedoHandler.Undo();
        System.out.println(vova.toString());
        UndoRedoHandler.Redo();
        System.out.println(vova.toString());
        UndoRedoHandler.Redo();
        System.out.println(vova.toString());
    }
}