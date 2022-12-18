package com.muzhesky.student.diplom;

import com.muzhesky.student.Student;

public class DiplomGenerator {
    public String GetDiplomNumber(Student student){
        return Integer.valueOf(student.getName().hashCode() +
                Double.valueOf(student.getAverageMark()).hashCode()).toString();
    }
}
