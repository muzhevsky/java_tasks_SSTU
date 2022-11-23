package com.muzhesky.departments;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    Employee boss;
    List<Employee> employeeList;

    public Department(String name, Employee boss) {
        this(name);

        this.boss = boss;
        this.boss.setDepartment(this);
        this.employeeList.add(boss);
    }

    public Department(String name) {
        if (name == null)
            throw new IllegalArgumentException("name cannot be null");

        this.name = name;
        employeeList = new ArrayList<>();
    }

    public void setBoss(Employee boss) {
        if (boss != null)
            boss.setDepartment(this);
        this.boss = boss;
    }

    public void addEmployee(Employee employee) {
        if (employee == null)
            throw new IllegalArgumentException("employee is null");

        if (!employeeIsIn(employee)) {
            this.employeeList.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(Employee employee) {
        if (employee == null)
            throw new IllegalArgumentException("employee is null");

        int index = 0;
        for (Employee emp : employeeList) {
            if (emp.equals(employee))
                break;
            index++;
        }

        if (index < employeeList.size()) {
            this.employeeList.get(index).department = null;
            this.employeeList.remove(index);
        }
    }

    boolean employeeIsIn(Employee employee) {
        for (Employee emp : employeeList)
            if (emp.equals(employee))
                return true;

        return false;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    @Override
    public String toString() {
        if (boss == null)
            return name;
        return name + " с начальником " + boss.name;
    }
}