package com.muzhevsky.spring.review;

public class Review {
    private String text;
    private int num;

    public String getText() {
        return text;
    }

    public int getNum() {
        return num;
    }

    public Review(String text, int num) {
        this.text = text;
        this.num = num;
    }

    @Override
    public String toString(){
        return text + num;
    }
}
