package org.example;

public class Name implements IPrintable {
    private String _firstname;
    private String _secondname;
    private String _patronymic;

    public Name(String firstname, String secondname, String patronymic){
        _firstname = firstname;
        _secondname = secondname;
        _patronymic = patronymic;
    }

    // АХАХХАХАХХАХАХХАХА НЕТ ЗНАЧЕНИЙ ПО УМОЛЧАНИЮ ДЛЯ МЕТОДОВ АХАХХАХАХХАХА

    public String getDataForPrinting(){
        String result = new String();
        if(_firstname !=null) result += _firstname +" ";
        if(_secondname !=null) result += _secondname +" ";
        if(_patronymic !=null) result += _patronymic;
        return result;
    }
}
