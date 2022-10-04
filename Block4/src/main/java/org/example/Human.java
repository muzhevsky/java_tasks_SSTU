package org.example;

public class Human {
    private Name name;
    private int height;
    public Human father;

    public Human(String name, int height){
        this.name = new Name(name);
        setHeight(height);
    }
    public Human(String name, int height, Human father){
        this(name,height);
        setFather(father);
    }
    public Human(Name name, int height, Human father){
        this(name,height);
        setFather(father);
    }
    public Human(Name name, int height){
        this.name = name;
        setHeight(height);
    }

    public void setHeight(int height){
        if(height > 50 && height < 220)
            this.height = height;
        else
            this.height = 175;
    }
    public void setFather(Human father){
        if (father == null){
            throw new IllegalArgumentException("father is null");
        }

        this.father = father;

        if(name.secondname == null && father.name.secondname != null)
            name.secondname = father.name.secondname;
        if(name.patronymic == null && father.name.firstname != null)
            name.patronymic = father.name.firstname +"ович";
    }

    public String toString(){
        return name + ", " + height;
    }
}