package org.example;

public class Name {
    public String Firstname;
    public String Secondname;
    public String Patronymic;

    public Name(String firstname, String secondname, String patronymic){
        Firstname = firstname;
        Secondname = secondname;
        Patronymic = patronymic;
    }


    public String toString(){
        String result = new String();
        if(Secondname !=null) result += Secondname;
        if(Firstname !=null) result += " "+ Firstname;
        if(Patronymic !=null) result += " "+ Patronymic;
        return result;
    }
}
