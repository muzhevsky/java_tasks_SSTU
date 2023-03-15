package com.muzhevsky.core.student.undoRedo;

import com.muzhevsky.core.student.Student;

abstract class StudentAction implements Action {
    protected Student student;

    public StudentAction() {

    }

    public StudentAction(Student student) {
        if (student == null)
            throw new IllegalArgumentException("student is null");

        this.student = student;
    }
}
