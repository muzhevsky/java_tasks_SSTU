package org.example;

public class Name {
    public String firstname;
    public String secondname;
    public String patronymic;

    public Name(String firstname, String secondname, String patronymic){
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
    }


    public String toString(){
        String result = new String();
        if(secondname !=null) result += secondname;
        if(firstname !=null) result += " "+ firstname;
        if(patronymic !=null) result += " "+ patronymic;
        return result;
    }
}
