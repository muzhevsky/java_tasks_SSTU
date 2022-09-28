package org.example;

public class Employee {
    private String _name;
    public String Name() {return _name;};

    public Department Department;

    public Employee(String name, Department department){
        _name = name;
        Department = department;
    }

    public String toString(){
        if(this == Department.Boss)
            return _name + " начальник отдела "+Department.Name();
        else
            return _name + " работает в отделе "+ Department.Name();
    }
}
