package com.notSmartCoder.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> marks;
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

    public int getMarksCount(){
        return marks.size();
    }

    public void addMarks(int... marks) {
        if (marks == null)
            throw new IllegalArgumentException("marks is null");
        if (!isValid(marks))
            throw new IllegalArgumentException("invalid marks");

        for (int item : marks) {
            this.marks.add(item);
            UndoHandler.getInstance().addAction(new StudentMarkAddAction(this,item));
        }
    }

    public void removeMark(int index){
        if(index >= marks.size())
            throw new IllegalArgumentException("index is more then list size");

        int value = marks.get(index);
        marks.remove(index);
        UndoHandler.getInstance().addAction(new StudentMarkRemoveAction(this, index, value));
    }

    public String getName(){
        return name;
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

    abstract class StudentAction implements Action{
        protected Student student;
        public StudentAction(){

        }
        public StudentAction(Student student){
            if (student == null)
                throw new IllegalArgumentException("student is null");

            this.student = student;
        }
    }

    class StudentMarkAddAction extends StudentAction{
        private int markValue;
        public StudentMarkAddAction(Student student, int markIndex){
            super(student);
            this.markValue = markIndex;
        }

        @Override
        public void Undo() {
            student.marks.remove(student.marks.size()-1);
        }

        @Override
        public void Redo() {
            student.marks.add(markValue);
        }
    }

    public class StudentMarkRemoveAction extends StudentAction {
        private int markIndex;
        private int markValue;
        public StudentMarkRemoveAction(Student student, int markIndex, int markValue){
            super(student);
            this.markIndex = markIndex;
            this.markValue = markValue;
        }

        @Override
        public void Undo() {
            student.marks.add(markIndex, markValue);
        }

        @Override
        public void Redo() {
            student.marks.remove(markIndex);
        }
    }

}