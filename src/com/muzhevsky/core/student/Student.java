package com.muzhevsky.core.student;

import com.muzhevsky.spring.utils.annotations.Invoke;
import com.muzhevsky.core.save.SaveObject;
import com.muzhevsky.core.student.diplom.DiplomGenerator;
import com.muzhevsky.core.student.diplom.StudentDismissalChecker;
import com.muzhevsky.core.student.marks.Mark;
import com.muzhevsky.core.student.undoRedo.Action;
import com.muzhevsky.core.student.undoRedo.UndoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

//@Component
public class Student {
    private String name;
    private List<Integer> marks;

    private Predicate<Integer> markChecker;
    private List<Mark> marks_2;
    private String diplomNumber;

    // Constructors
//    @Autowired
    public Student() {
        marks = new ArrayList<>();
        markChecker = (mark) -> true;
    }

    public Student(String name, Mark... marks) {
        this(name);
        marks_2 = new ArrayList<>();
        for (Mark mark : marks)
            marks_2.add(mark);
    }

    public Student(String name) {
        this();
        if (name == null)
            throw new IllegalArgumentException("name is null");

        this.name = name;
    }

    public Student(String name, int... marks) {
        this(name);
        addMarks(marks);
    }

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }


    public Student(Student student) {
        this(student.name, student.marks);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double getAverageMark() {
        double average = 0;
        for (Mark mark : marks_2)
            average += mark.getValue();

        average /= marks_2.size();

        return average;
    }

    public double getAverageIntMark(){
        double average = marks.stream()
                .reduce(0, (a,b)->a+b);

        average /= marks.size();

        return average;
    }

    public ArrayList<Integer> getMarks() {
        return new ArrayList<>(this.marks);
    }

    @Invoke
    private int test2() {return 5;}
    @Invoke
    public int getMarksCount() {
        return marks.size();
    }

//    @Autowired()
//    @Qualifier("predicate")
    public void setMarkChecker(Predicate<Integer> markChecker){
        if (markChecker == null) throw new IllegalArgumentException("markChecker is null");
        this.markChecker = markChecker;
    }

    public void setName(String name){
        if (name == null) throw new IllegalArgumentException("name is null");
        this.name = name;
    }

    public void addMarks(int... marks) {
        if (marks == null)
            throw new IllegalArgumentException("marks is null");
        if (!isValid(marks))
            throw new IllegalArgumentException("invalid marks");

        for (int item : marks) {
            this.marks.add(item);
            UndoHandler.getInstance().addAction(new StudentMarkAddAction(this, item));
        }
    }

    public void removeMark(int index) {
        if (index >= marks.size())
            throw new IllegalArgumentException("index is more then list size");

        int value = marks.get(index);
        marks.remove(index);
        UndoHandler.getInstance().addAction(new StudentMarkRemoveAction(this, index, value));
    }

    public boolean Dismiss(StudentDismissalChecker... checks) {
        if (diplomNumber != null)
            return false; // student is already dismissed

        for (StudentDismissalChecker checker : checks)
            if (!checker.checkStudent(this))
                return false;

        diplomNumber = new DiplomGenerator().GetDiplomNumber(this);
        return true;
    }

    public String getName() {
        return name;
    }

    private boolean isValid(int... marks) {
        for (int item : marks)
            if (!markChecker.test(item))
                return false;

        return true;
    }

    public String toString() {
        String marksString = "";

        for (Integer mark : marks)
            marksString += mark.toString() + " ";

        return "Student{ name = '" + name + "', marks = [ " + marksString + " ]";
    }

    // Inner classes
    public class StudentSave implements SaveObject<Student> {
        private String name;
        private List<Integer> marks;

        private Predicate<Integer> markChecker;
        public StudentSave() {
            name = Student.this.name;
            marks = new ArrayList<>(Student.this.marks);
            markChecker = Student.this.markChecker;
        }

        @Override
        public Student load() {
            return new Student(name, marks);
        }
    }

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

    public class StudentMarkAddAction extends StudentAction {
        private int markValue;

        public StudentMarkAddAction(Student student, int markIndex) {
            super(student);
            this.markValue = markIndex;
        }

        @Override
        public void Undo() {
            student.marks.remove(student.marks.size() - 1);
        }

        @Override
        public void Redo() {
            student.marks.add(markValue);
        }
    }

    public class StudentMarkRemoveAction extends StudentAction {
        private int markIndex;
        private int markValue;

        public StudentMarkRemoveAction(Student student, int markIndex, int markValue) {
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}