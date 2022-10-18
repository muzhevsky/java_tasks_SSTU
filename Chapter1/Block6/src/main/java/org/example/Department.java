package org.example;

public class Department {
    private String name;
    private Employee boss;

    public Department(String name, Employee boss){
        this.name = name;
        this.boss = boss;
        this.boss.setDepartment(this);
    }

    public void setBoss(Employee boss){
        if(boss != null)
            boss.setDepartment(this);
        this.boss = boss;
    }

    public String getName(){
        return name;
    }
    public Employee getBoss(){
        return boss;
    }
}
