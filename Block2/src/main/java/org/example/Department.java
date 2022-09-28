package org.example;

public class Department {
    private String _name;
    public String Name() {return _name;};
    public Employee Boss;

    public Department(String name, Employee boss){
        _name = name;
        Boss = boss;
    }
}
