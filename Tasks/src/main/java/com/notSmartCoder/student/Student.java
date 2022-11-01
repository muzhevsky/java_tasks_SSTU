package com.notSmartCoder.student;

import java.util.Arrays;

public class Student {
    public String name;
    private int[] marks;
    private int actualLength;

    public Student() {
        name = "";
        marks = new int[0];
        actualLength = 0;
    }

    public Student(String name, int... marks) {
        if (name == null)
            throw new IllegalArgumentException("name is null");
        this.name = name;

        if (marks != null) {
            if (!isValid(marks))
                throw new IllegalArgumentException("invalid marks");

            this.marks = Arrays.copyOf(marks, marks.length);
            actualLength = marks.length;
        }
    }

    public void setMarks(int... marks) {
        if (marks != null) {
            if (!isValid(marks))
                throw new IllegalArgumentException("invalid marks");

            this.marks = Arrays.copyOf(marks, marks.length);
            actualLength = marks.length;
        }
        else this.marks = new int[0];
    }

    public int[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    public void addMarks(int... marks) {

        if (!isValid(marks))
            throw new IllegalArgumentException("invalid marks");

        if (actualLength + marks.length > this.marks.length) {
            this.marks = Arrays.copyOf(this.marks, this.marks.length * 2);
        }

        for (int item : marks) {
            this.marks[actualLength++] = item;
        }
    }

    private boolean isValid(int...marks) {
        for (int item : marks)
            if (item > 5 || item < 2)
                return false;

        return true;
    }

    public String toString() {
        String marksString = "";

        if (this.marks.length > 0) {
            for (int i = 0; i < actualLength - 1; i++)
                marksString += this.marks[i] + ", ";

            marksString += this.marks[actualLength - 1];
        }

        return "Student{ name = '" + name + "', marks = [ " + marksString + " ]";
    }
}
