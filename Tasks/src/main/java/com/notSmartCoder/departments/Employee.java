package com.notSmartCoder.departments;

import java.util.Objects;

public class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this(name);

        this.department = department;
    }

    public Employee(String name) {
        if (name == null)
            throw new IllegalArgumentException("name is null");

        this.name = name;
    }

    void setDepartment(Department department) {
        if (this.department != null) {
            if (this.department.boss != null && this.department.boss.equals(this))
                this.department.boss = null;

            this.department.removeEmployee(this);
        }

        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if (department == null)
            return name;
        if (department.boss != null && this == department.boss)
            return name + " начальник отдела " + department.name;

        return name + " работает в отделе " + department.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department);
    }
}