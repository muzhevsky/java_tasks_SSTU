package com.notSmartCoder.student;

public class StudentMarkRemoveAction extends StudentAction{
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
