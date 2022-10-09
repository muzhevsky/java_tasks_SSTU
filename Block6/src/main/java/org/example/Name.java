package org.example;

public class Name {
    private String firstname;
    private String secondname;
    private String patronymic;


    public Name(String firstname) {
        if (firstname != null && firstname != "")
            this.firstname = firstname;
        //else ... ну короче обработка неправильных значений какая-то
    }

    public Name(String firstname, String secondname) {
        this(firstname);
        if (secondname != null && secondname != "")
            this.secondname = secondname;
        //else ... ну короче обработка неправильных значений какая-то
    }

    public Name(String firstname, String secondname, String patronymic) {
        this(firstname, secondname);
        if (patronymic != null && patronymic != "")
            this.patronymic = patronymic;
        //else ... ну короче обработка неправильных значений какая-то
    }

    public Name(Name name){
        this.firstname = name.getFirstname();
        this.secondname = name.getSecondname();
        this.patronymic = name.getPatronymic();
    }
//    public void setFirstname(String firstname) {
//        if (firstname == null || firstname == "")
//            throw new IllegalArgumentException("wrong firstname");
//        this.firstname = new String(firstname);
//    }
//
//    public void setSecondname(String secondname) {
//        if (secondname == null || secondname == "")
//            throw new IllegalArgumentException("wrong secondname");
//        this.secondname = secondname;
//    }
//
//    public void setPatronymic(String patronymic) {
//        if (patronymic == null || patronymic == "")
//            throw new IllegalArgumentException("wrong patronymic");
//        this.patronymic = patronymic;
//    }

    public String getFirstname() {
        return new String(firstname);
    }

    public String getSecondname() {
        return new String(secondname);
    }

    public String getPatronymic() {
        return new String(patronymic);
    }

    public String toString() {
        String result = new String();
        if (firstname != null) result += firstname + " ";
        if (secondname != null) result += secondname + " ";
        if (patronymic != null) result += patronymic;
        return result;
    }
}
