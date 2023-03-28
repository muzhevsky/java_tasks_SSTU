package com.muzhevsky.core.utils.defaultHandling;

import com.muzhevsky.core.utils.annotations.Invoke;

public class DefaultConfig {
    @Invoke
    public String getString(){
        return "hello";
    }

    public Integer getInteger(){
        return 5;
    }

}
