package com.notSmartCoder.main;

import com.notSmartCoder.animals.Cat;
import com.notSmartCoder.animals.Meowable;
import com.notSmartCoder.animals.MeowAlerter;
import com.notSmartCoder.animals.MeowCounter;
import com.notSmartCoder.student.RedoHandler;
import com.notSmartCoder.student.Student;
import com.notSmartCoder.student.UndoHandler;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("asd", 2,3,2,4);
        System.out.println(student.getMarks());
        UndoHandler undoHandler = UndoHandler.getInstance();
        RedoHandler redoHandler = RedoHandler.getInstance();

        undoHandler.Undo();
        System.out.println(student.getMarks());
        undoHandler.Undo();
        System.out.println(student.getMarks());
        undoHandler.Undo();
        System.out.println(student.getMarks());
        undoHandler.Undo();
        System.out.println(student.getMarks());

        redoHandler.Redo();
        System.out.println(student.getMarks());
        redoHandler.Redo();
        System.out.println(student.getMarks());
        redoHandler.Redo();
        System.out.println(student.getMarks());
        redoHandler.Redo();
        System.out.println(student.getMarks());

        undoHandler.Undo();
        System.out.println(student.getMarks());
        redoHandler.Redo();
        System.out.println(student.getMarks());

        student.removeMark(2);
        System.out.println(student.getMarks());
        undoHandler.Undo();
        System.out.println(student.getMarks());
    }

    public static void doMeow(Meowable meowable){
        meowable.meow();
    }
}