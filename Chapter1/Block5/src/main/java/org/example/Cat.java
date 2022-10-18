package org.example;

public class Cat {
    private String name;

    public Cat(String name){
        if (name != null && name.length() > 0)
            this.name = name;
        else
            throw new IllegalArgumentException("invalid name format");
    }

    public void sayMeow(){
        System.out.println(name+" meow");
    }
    public void sayMeow(int number){
        if(number < 1)
            throw new IllegalArgumentException("wrong meow number");

        String meowString = "";
        for(int i = 0; i < number; i++){
            meowString += " meow";
        }

        System.out.println(name+meowString);
    }

    public String toString(){
        return "cat: " + name;
    }
}
