package org.example;

public class Name {
    public String Firstname;
    public String Secondname;
    public String Patronymic;

    // АХАХХАХАХХАХАХХАХА НЕТ ЗНАЧЕНИЙ ПО УМОЛЧАНИЮ ДЛЯ МЕТОДОВ АХАХХАХАХХАХА

    public String getInfo(){
        String result = new String();
        if(Firstname!=null) result += Firstname+" ";
        if(Secondname!=null) result += Secondname+" ";
        if(Patronymic!=null) result += Patronymic;
        return result;
    }
}
