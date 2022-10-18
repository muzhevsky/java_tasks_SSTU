package org.example;

public class Employee {
    private String name;
    public String Name() {return name;};

    public Department department;

    public Employee(String name, Department department){
        this.name = name;
        this.department = department;
    }

    public String toString(){
        if(this == department.Boss)
            return name + " начальник отдела "+ department.Name();
        else
            return name + " работает в отделе "+ department.Name();
    }
}
