package com.muzhevsky.student.diplom;

import com.muzhevsky.student.Student;

public class DiplomGenerator {
    public String GetDiplomNumber(Student student) {
        return Integer.valueOf(student.getName().hashCode() +
                Double.valueOf(student.getAverageMark()).hashCode()).toString();
    }
}
