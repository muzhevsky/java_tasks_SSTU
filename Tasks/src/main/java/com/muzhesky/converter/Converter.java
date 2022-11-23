package com.muzhesky.converter;

public class Converter<T1,T2> {
    public void doSomeMagic(Reader<T1> reader,
                            Handler<T1, T2> handler,
                            Sender<T2> sender)/* можно без sender'a, тогда
                            конвертер будет отвечать и за вывод тоже*/
    {
        sender.send(handler.handle(reader.read()));
    }
}