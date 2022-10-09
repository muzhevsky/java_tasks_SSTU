package org.example;

public class Name {
    public String firstname;
    public String secondname;
    public String patronymic;


    public Name(String firstname) {
        if (firstname != null)
            this.firstname = firstname;
        //else ... ну короче обработка неправильных значений какая-то
    }

    public Name(String firstname, String secondname) {
        this(firstname);
        if (secondname != null)
            this.secondname = secondname;
        //else ... ну короче обработка неправильных значений какая-то
    }

    public Name(String firstname, String secondname, String patronymic) {
        this(firstname, secondname);
        if (this.patronymic != null)
            this.patronymic = patronymic;
        //else ... ну короче обработка неправильных значений какая-то
    }

    public String toString() {
        String result = new String();
        if (firstname != null) result += firstname + " ";
        if (secondname != null) result += secondname + " ";
        if (patronymic != null) result += patronymic;
        return result;
    }
}
