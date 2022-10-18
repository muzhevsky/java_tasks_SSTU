package org.example;

public class Name{
    private String firstname;
    private String secondname;
    private String patronymic;

    public Name(String firstname, String secondname, String patronymic){
        this.firstname = firstname;
        this.secondname = secondname;
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
