package com.muzhevsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Storage {
    @Autowired
    private ApplicationContext ctx;
    private List<String> list = new ArrayList<>();

    public void put(String str){
        list.add(str);
    }

    public <T> T get(int index, Class<T> type) throws Exception{
        return ((Converter<T>)ctx.getBean(type.getSimpleName()+"Converter")).convert(list.get(index));
    }
}