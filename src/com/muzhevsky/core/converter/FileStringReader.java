package com.muzhevsky.core.converter;

public class FileStringReader implements Reader<String> {
    String result;

    public FileStringReader(String path) {
        /*path*/
        result = "123";
    }

    public String read() {
        return result;
    }
}
