package com.notSmartCoder.student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
    List<Integer> marks;

    private MarkChecker markChecker;
    private Student() {
        markChecker = new DefaultMarkChecker();
        marks = new ArrayList<>();
    }

    public Student(String name){
        this();
        if (name == null)
            throw new IllegalArgumentException("name is null");

        this.name = name;
    }

    public Student(String name, int... marks) {
        this(name);
        addMarks(marks);
    }

    public Student(String name, MarkChecker markChecker, int...marks) {
        this(name);
        if(markChecker == null)
            throw new IllegalArgumentException("markChecher is null");
        this.markChecker = markChecker;

        addMarks(marks);
    }

    public ArrayList<Integer> getMarks() {
        return new ArrayList<>(this.marks);
    }

    public void addMarks(int... marks) {
        if (marks == null)
            throw new IllegalArgumentException("marks is null");
        if (!isValid(marks))
            throw new IllegalArgumentException("invalid marks");


        for (int item : marks) {
            this.marks.add(item);
            UndoRedoHandler.addUndoAction(new StudentMarkAddAction(this,item));
        }
    }

    public void removeMark(int index){
        if(index >= marks.size())
            throw new IllegalArgumentException("index is more then list size");

        int value = marks.get(index);
        marks.remove(index);
        UndoRedoHandler.addUndoAction(new StudentMarkRemoveAction(this, index, value));
    }

    public void insertMark(int index){
        if(index >= marks.size())
            throw new IllegalArgumentException("index is more then list size");


    }

    private boolean isValid(int...marks) {
        for (int item : marks)
            if (!markChecker.Check(item))
                return false;

        return true;
    }

    public String toString() {
        String marksString = "";

        for(Integer mark : marks)
            marksString += mark.toString() + " ";

        return "Student{ name = '" + name + "', marks = [ " + marksString + " ]";
    }
}