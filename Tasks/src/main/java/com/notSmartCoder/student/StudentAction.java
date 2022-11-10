package com.notSmartCoder.student;

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
