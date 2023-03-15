package com.muzhevsky.core.converter;

public class Converter<T1, T2> { // front-object
    public void convert(Reader<T1> reader,
                        Handler<T1, T2> handler,
                        Writer<T2> writer) {
        writer.write(handler.handle(reader.read()));
    }
}

abstract class ConverterV2 { // шаблонный метод
    public abstract void read();

    public abstract void handle();

    public abstract void write();

    public final void convert() {
        read();
        handle();
        write();
    }
}