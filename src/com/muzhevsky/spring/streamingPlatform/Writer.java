package com.muzhevsky.spring.streamingPlatform;

public interface Writer {
    void write(String data);
    void write(byte[] data);
}
