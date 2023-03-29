package com.muzhevsky.spring.streamingPlatform;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class MyFileWriter implements Writer {
    String path;
    FileOutputStream fileOutputStream;
    public void setPath(String path) throws FileNotFoundException {
        if (path == null) throw new IllegalArgumentException();
        this.path = path;
        fileOutputStream = new FileOutputStream(path);
    }
    @Override
    public void write(String data) {
        try {
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("wrote string to file " + path);
    }

    @Override
    public void write(byte[] data) {
        try {
            fileOutputStream.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("wrote byte[] to file " + path);
    }
}
