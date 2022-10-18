package org.example;

public class Name {
    private String firstname;
    private String secondname;
    private String patronymic;


    public Name(String firstname) {
        if (firstname != null && firstname != "")
            this.firstname = firstname;
        else
            throw new IllegalArgumentException("firstname is null");
    }

    public Name(String firstname, String secondname) {
        this(firstname);
        if (secondname != null && secondname != "")
            this.secondname = secondname;
        else
            throw new IllegalArgumentException("secondname is null");
    }

    public Name(String firstname, String secondname, String patronymic) {
        this(firstname, secondname);
        if (patronymic != null && patronymic != "")
            this.patronymic = patronymic;
        else
            throw new IllegalArgumentException("patronymic is null");
    }

    public Name(Name name){
        this.firstname = name.getFirstname();
        this.secondname = name.getSecondname();
        this.patronymic = name.getPatronymic();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String toString() {
        String result = new String();
        if (firstname != null) result += firstname + " ";
        if (secondname != null) result += secondname + " ";
        if (patronymic != null) result += patronymic;
        return result;
    }
}
