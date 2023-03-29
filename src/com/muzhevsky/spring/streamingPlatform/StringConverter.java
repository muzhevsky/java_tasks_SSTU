package com.muzhevsky.spring.streamingPlatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class StringConverter {
    private Reader reader;
    private Writer writer;
    private List<StringHandler> handlers = new ArrayList<>();


    public void handle(Reader reader, Writer writer){
        if (reader == null || writer == null) throw new IllegalArgumentException();
        this.reader = reader;
        this.writer = writer;

        String data = reader.readString();
        for (var handler : handlers){
            data = handler.handle(data);
        }
        writer.write(data);
    }

    public StringConverter addHandler(StringHandler handler){
        if (handler == null) throw new IllegalArgumentException();
        handlers.add(handler);
        return this;
    }
}
