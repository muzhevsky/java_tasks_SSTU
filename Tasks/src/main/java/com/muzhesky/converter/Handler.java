package com.muzhesky.converter;

public interface Handler<T1,T2> {
    public T2 handle(T1 object);
}
