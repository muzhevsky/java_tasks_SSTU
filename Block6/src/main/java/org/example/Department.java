package org.example;

public class Department {
    private String name;
    private Employee boss;

    public Department(String name, Employee boss){
        this.name = name;
        this.boss = boss;
        this.boss.setDepartment(this);
    }

    public String getName(){
        return new String(name);
    }
    public Employee getBoss(){
        return boss;
    }
}
