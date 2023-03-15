package com.muzhevsky.spring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class HomeworkConfig {

    @Bean
    public String helloWorld() {
        return "Hello World!";
    }

    @Bean
    @Scope("prototype")
    public int random() {
        var rand = new Random();
        return rand.nextInt();
    }

    @Bean
    @Lazy
    public Date date() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> predicate() {
        return (num) -> num <= 5 && num >= 2;
    }

    @Bean
    public int min(){
        return Integer.MIN_VALUE;
    }

    @Bean
    public int max(){
        return Integer.MAX_VALUE;
    }
}