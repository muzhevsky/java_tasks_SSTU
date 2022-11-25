package com.muzhesky.main;

import com.muzhesky.animals.Meowable;
import com.muzhesky.converter.Converter;
import com.muzhesky.converter.FileStringReader;
import com.muzhesky.converter.IntegerWriterToConsole;
import com.muzhesky.converter.StringToIntegerHandler;
import com.muzhesky.student.Student;
import com.muzhesky.student.UndoHandler;
import save.SaveHandler;

public class Main {
    public static void main(String[] args) {

    }

    public static void doMeow(Meowable meowable){
        meowable.meow();
    }
}