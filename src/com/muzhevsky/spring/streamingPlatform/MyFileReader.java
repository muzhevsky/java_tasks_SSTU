package com.muzhevsky.spring.streamingPlatform;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class MyFileReader implements Reader {
    String path;
    FileInputStream fileInputStream;

    public void setPath(String path) throws FileNotFoundException {
        if (path == null) throw new IllegalArgumentException();
        this.path = path;
        fileInputStream = new FileInputStream(path);
    }

    @Override
    public String readString() {
        return new String(readBytes());
    }

    @Override
    public byte[] readBytes() {
        try {
            byte[] data = fileInputStream.readAllBytes();
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
