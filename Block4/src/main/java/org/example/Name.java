package org.example;

public class Name{
    public String firstname;
    public String secondname;
    public String patronymic;


    public Name(String firstname){
        this.firstname = firstname;
    }
    public Name(String firstname, String secondname){
        this(firstname);
        this.secondname = secondname;
    }
    public Name(String firstname, String secondname, String patronymic){
        this(firstname,secondname);
        this.patronymic = patronymic;
    }

    public String toString(){
        String result = new String();
        if(firstname !=null) result += firstname +" ";
        if(secondname !=null) result += secondname +" ";
        if(patronymic !=null) result += patronymic;
        return result;
    }
}
