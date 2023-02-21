package com.muzhesky.reflection.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class MsonWriter{
    FileWriter fileWriter;
    public void write(Iterable<Object> objects, String filePath) throws IOException{

        File file = new File(filePath);
        fileWriter = new FileWriter(file);

        StringBuilder stringBuilder = new StringBuilder(64);
        for(Object obj : objects){
            stringBuilder.append(MsonHelper.serialise(obj));
        }

        fileWriter.write(stringBuilder.toString());
    }
    public void close() throws IOException{
        fileWriter.close();
    }
}
