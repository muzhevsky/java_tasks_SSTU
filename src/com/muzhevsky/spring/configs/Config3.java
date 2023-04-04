package com.muzhevsky.spring.configs;

import com.muzhevsky.spring.utils.test.SomeClass;
import com.muzhevsky.spring.utils.test.SomeClassTests;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config3 {
    @Bean("someObject")
    @Scope("prototype")
    public SomeClass someObject() {
        return new SomeClass("test", 5);
    }

    @Bean("someClassTests")
    @Scope("singleton")
    public SomeClassTests someClassTests() {
        return new SomeClassTests();
    }

    @Bean("hello")
    public String hello(){
        return "hello";
    }
}
