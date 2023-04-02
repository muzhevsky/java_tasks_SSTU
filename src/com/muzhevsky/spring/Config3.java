package com.muzhevsky.spring;

import com.muzhevsky.spring.utils.test.SomeClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config3 {
    @Bean("someObject")
    @Scope("prototype")
    public SomeClass someObject(){
        return new SomeClass("test",5);
    }
}
