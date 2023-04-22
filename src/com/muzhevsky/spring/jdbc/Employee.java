package com.muzhevsky.spring.jdbc;


import lombok.Getter;

public class Employee {
    @Getter
    private int id;

    @Getter
    private String name;

    @Getter
    private String surname;

    @Getter
    private int departmentId;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
