package com.muzhevsky.core.converter;

public class FileByteReader implements Reader<Byte[]> {
    public Byte[] read() {
        return new Byte[]{1, 2, 4};
    }
}
