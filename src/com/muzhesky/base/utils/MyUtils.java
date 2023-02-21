package com.muzhesky.base.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUtils {
    public static Collection<String> fieldCollection(Object obj){
        Field[] fields = obj.getClass().getFields();

        Collection<String> result = new ArrayList<>();
        for(Field f : fields){
            result.add(f.getName());
        }

        return result;
    }
}
