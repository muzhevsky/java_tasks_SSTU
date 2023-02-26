package com.muzhevsky.reflection.utils;

import java.io.File;
import java.util.Scanner;

public class MsonReader<T> {
    Scanner scanner;
    int position = 0;
    String filePath;

    public MsonReader(String filePath) {
        this.filePath = filePath;
    }

    public T readLine() throws Exception {
        File file = new File(filePath);
        scanner = new Scanner(file);

        if (!scanner.hasNext()) {
            return null;
        }

        char[] str = scanner.next().toCharArray();
        return (T) MsonHelper.deserialise(str, 0);
    }

    public void reset() {
        position = 0;
    }
}
