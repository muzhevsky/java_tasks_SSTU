package com.notSmartCoder.student;

class StudentMarkAddAction extends StudentAction{
    int markValue;

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
