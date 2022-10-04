package org.example;

import java.util.ArrayList;

public class Department {
    private String name;
    private Employee boss;
    private ArrayList<Employee> employees;


    public Department(String name, Employee boss){
        this.name = name;
        this.boss = boss;
        employees = new ArrayList<Employee>();
        boss.setDepartment(this);
    }


    public String getName() {
        return name;
    };
    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        if(boss != null)
            this.boss = boss;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public ArrayList<Employee> getAllEmpoyees(){
        return new ArrayList<Employee>(employees);
    }

}
