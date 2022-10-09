package org.example;

public class Human {
    private Name name;
    private int height;



    private Human father;

    public Human(String name, int height) {
        this(new Name(name), height);
    }
    public Human(String name, int height, Human father) {
        this(new Name(name), height, father);
    }
    public Human(Name name, int height, Human father) {
        this(name, height);
        if(father == null)
            throw new IllegalArgumentException("father is null");
        this.father = new Human(father);
    }
    public Human(Name name, int height) {
        if(name == null)
            throw new IllegalArgumentException("name is null");
        this.name = new Name(name);
        this.height = height;
    }
    public Human(Human human){
        this.name = human.getName();
        this.height = human.getHeight();
        this.father = human.getFather();
    }

    public int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        if (height < 0 || height > 500)
            throw new IllegalArgumentException("invalid height");
        this.height = height;
    }

    public Human getFather(){
        return father;
    }
    public Name getName(){
        return name;
    }

    public String toString() {
        return name + ", " + height;
    }
}