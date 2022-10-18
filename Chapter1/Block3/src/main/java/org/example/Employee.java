package org.example;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this(name);
        setDepartment(department);
    }

    public Employee(String name) {
        if (name == null || name == "")
            throw new IllegalArgumentException("mne uje len' pisat' exception'bI... ");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department dep) {
        if (dep != null) {
            if (department != null)
                department.removeEmployee(this);
            department = dep;
            department.addEmployee(this);
        } else
            throw new IllegalArgumentException("mne uje len' pisat' exception'bI... ");
    }


    public String toString() {
        if (this == department.getBoss())
            return name + " начальник отдела " + department.getName();
        else
            return name + " работает в отделе " + department.getName();
    }
}
