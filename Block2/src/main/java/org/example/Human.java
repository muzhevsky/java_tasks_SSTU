package org.example;

public class Human {
    private Name Name;
    private int _height;
    public Human Father;

    public Human(Name name, int height){
        Name = name;

        if(height > 50)
            _height = height;
        else
            _height = 175;
    }

    public String toString(){

        if (Father == null) return Name.toString() + ", " + _height;
        else{
            Name name = new Name(Name.Firstname, Name.Secondname, Name.Patronymic);

            if(name.Secondname == null && Father.Name.Secondname != null)
                name.Secondname = Father.Name.Secondname;
            if(name.Patronymic == null && Father.Name.Firstname != null)
                name.Patronymic = Father.Name.Firstname+"ович";

            return name + ", " + _height;
        }
    }
}