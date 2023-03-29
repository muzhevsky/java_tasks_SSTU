package com.muzhevsky.spring;

import com.muzhevsky.core.shareBots.*;
import com.muzhevsky.core.student.Student;
import com.muzhevsky.core.trafficLight.Colorable;
import com.muzhevsky.spring.streamingPlatform.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class Config2 {
    private final List<Integer> randomList = new LinkedList<>();

    private void initRandomList() {
        for (int i = min(); i < max(); i++)
            randomList.add(i);
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
    public Review veryGoodReview() {
        return new Review("Очень хорошо.", 4);
    }

    @Bean("meanReview")
    public Review meanReview() {
        return new Review("Сойдет.", 3);
    }

    @Bean("randomReview")
    public Review randomReview(@Qualifier
                                       ("random") int random) {
        return new Review("Сойдет.", random);

    }

    @Bean("bestReview")
    public Review bestReview(List<Review> reviews) {
        if (reviews.size() == 0) return null;
        Review result = reviews.get(0);
        for (var item : reviews) {
            if (result.getNum() < item.getNum())
                result = item;
        }
        return result;
    }

    @Bean
    @Scope("prototype")
    @Qualifier("defaultStudent")
    public Student defaultStudent() {
        return new Student();
    }

    @Bean
    @Scope("prototype")
    @Qualifier("anotherStudent")
    public Student anotherStudent() {
        return new Student("asdadwadqw", 3,2,4,5);
    }

    @Bean
    @Qualifier("studentCreator")
    public StudentCreator studentCreator(@Qualifier("predicate")Predicate<Integer> range){
        return new StudentCreator();
    }

    @Bean
    @Qualifier("green")
    public Colorable green(@Lazy @Qualifier("red") Colorable red) {
        return new NewColor("green", red);
    }

    @Bean
    @Qualifier("red")
    public Colorable red(@Lazy @Qualifier("green") Colorable green) {
        return new NewColor("red", green);
    }

    @Bean
    @Qualifier("black")
    public Colorable black() {
        var black = new NewColor("black", null);
        black.setNext(black);
        return black;
    }

    @Bean
    @Qualifier("trafficLight")
    public Colorable trafficLight(@Qualifier("black") Colorable black, @Qualifier("green") Colorable green) {
        return new NewTrafficLight(black, green);
    }

    @Bean
    @Qualifier("min")
    public int min() {
        return 10;
    }

    @Bean
    @Qualifier("max")
    public int max() {
        return 20;
    }


    @Bean
    @Qualifier("fileReader")
    @Scope("prototype")
    public MyFileReader fileReader() {
        return new MyFileReader();
    }

    @Bean
    @Qualifier("fileWriter")
    @Scope("prototype")
    public MyFileWriter fileWriter() {
        return new MyFileWriter();
    }

    @Bean
    @Qualifier("stringTrimHandler")
    public StringHandler stringTrimHandler() {
        return new StringTrimHandler();
    }

    @Bean
    @Qualifier("stringToUpperHandler")
    public StringHandler stringToUpperHandler() { return new StringToUpperHandler(); }

    @Bean
    @Qualifier("stringDoublerHandler")
    public StringHandler stringDoublerHandler() {
        return new StringDoublerHandler();
    }

    @Bean
    @Qualifier("stringConverter")
    public StringConverter stringConverter(@Qualifier("stringTrimHandler") StringHandler stringTrimHandler,
                                           @Qualifier("stringDoublerHandler") StringHandler stringDoublerHandler,
                                           @Qualifier("stringToUpperHandler") StringHandler stringToUpperHandler) {
        var converter = new StringConverter();

        converter.addHandler(stringTrimHandler)
                .addHandler(stringDoublerHandler)
                .addHandler(stringToUpperHandler);

        return converter;
    }

    @Bean
    @Qualifier("sellRule1")
    public CheckRule sellRule1(){
        return new CheckRule() {
            @Override
            public boolean check(double prevValue, double nextValue) {
                if (nextValue - prevValue > 10) return true;
                return false;
            }
        };
    }

    @Bean
    @Qualifier("buyRule1")
    public CheckRule buyRule1(){
        return new CheckRule() {
            @Override
            public boolean check(double prevValue, double nextValue) {
                if (nextValue - prevValue < -10) return true;
                return false;
            }
        };
    }

    @Bean
    @Qualifier("tradeBot1")
    public TradeBot tradeBot1(@Qualifier("buyRule1") CheckRule buyRule, @Qualifier("sellRule1") CheckRule sellRule){
        return new DefaultTradeBot(buyRule, sellRule);
    }

    @Bean
    @Qualifier("exchange")
    public Exchange exchange(){
        var exchange = new Exchange();
        var share1 = new Share("test1", 50);
        var share2 = new Share("test2", 100);
        exchange.addShare(share1);
        exchange.addShare(share2);

        return exchange;
    }
}
