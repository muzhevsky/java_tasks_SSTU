package com.muzhevsky.spring;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.Scope;

import com.muzhevsky.core.student.Student;
import com.muzhevsky.core.trafficLight.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class DefaultConfig {

    private final List<Integer> randomList = new LinkedList<>();
    private void initRandomList(){
        for (int i = min(); i < max(); i++)
            randomList.add(i);
    }
    @Bean
    public String helloWorld() {
        return "Hello World!";
    }

    @Bean
    @Scope("prototype")
    @Qualifier("random")
    public int random(@Qualifier("min") int min, @Qualifier("max") int max) {
        if (randomList.size() == 0)
            initRandomList();

        var rand = new Random();
        var randomIndex = rand.nextInt(0, randomList.size());
        var value = randomList.get(randomIndex);
        randomList.remove(randomIndex);
        return value;
    }

    @Bean("veryGoodReview")
    public Review veryGoodReview(){
        return new Review("Очень хорошо.", 4);
    }

    @Bean("meanReview")
    public Review meanReview(){
        return new Review("Сойдет.", 3);
    }

    @Bean("randomReview")
    public Review randomReview(@Qualifier("random") int random){
        return new Review("Сойдет.", random);
    }

    @Bean("bestReview")
    public Review bestReview(List<Review> reviews){
        if (reviews.size() == 0) return null;
        Review result = reviews.get(0);
        for (var item : reviews){
            if (result.getNum() < item.getNum())
                result = item;
        }

        return result;
    }

    @Bean
    public Student student(){
        return new Student();
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
    @Qualifier("min")
    public int min(){
        return 10;
    }

    @Bean
    @Qualifier("max")
    public int max(){
        return 20;
    }


    @Bean
    @Qualifier("green")
    @Lazy
    public Colorable green(@Lazy @Qualifier("red") Colorable red){
        return new NewColor("green", red);
    }

    @Bean
    @Qualifier("red")
    @Lazy
    public Colorable red(@Lazy @Qualifier("green") Colorable green){
        return new NewColor("red", green);
    }

    @Bean
    @Qualifier("black")
    @Lazy
    public Colorable black(@Lazy @Qualifier("green") Colorable green){
        return new NewColor("black", green);
    }

    @Bean
    @Qualifier("trafficLight")
    @Lazy
    public Colorable trafficLight(@Lazy @Qualifier("black") Colorable defaultColor){
        return new NewTrafficLight(defaultColor);
    }
}