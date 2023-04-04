package com.muzhevsky.spring.defaultHandling;

import com.muzhevsky.spring.utils.annotations.Invoke;

public class DefaultConfig {
    @Invoke
    public String getString() {
        return "hello";
    }

    public Integer getInteger() {
        return 5;
    }

}
