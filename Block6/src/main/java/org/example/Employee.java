package org.example;

public class Employee {
    private String name;

    private Department department;

    public Employee(String name, Department department){
        this.name = name;
        this.department = department;
    }

    public String toString(){
        if(this == department.getBoss())
            return name + " начальник отдела "+ department.getName();
        else
            return name + " работает в отделе "+ department.getName();
    }

    public void setDepartment(Department department){
        if (department == null)
            throw new IllegalArgumentException("department is null");

        this.department = department;
    }
}
