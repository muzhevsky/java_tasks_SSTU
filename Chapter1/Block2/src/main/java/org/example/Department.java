package org.example;

public class Department {
    private String name;
    public String Name() {return name;};
    public Employee Boss;

    public Department(String name, Employee boss){
        this.name = name;
        Boss = boss;
    }
}
