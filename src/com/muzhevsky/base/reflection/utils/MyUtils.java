package com.muzhesky.reflection.utils;

import com.muzhesky.geometry.Line;
import com.muzhesky.reflection.utils.test.ValidateException;
import com.sun.jdi.InvocationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public abstract class MyUtils {
    public static Set<Field> getAllFields(Object obj){
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] fields = obj.getClass().getFields();

        Set<Field> allFields = new HashSet<>();

        for(Field f : declaredFields) allFields.add(f);
        for(Field f : fields) allFields.add(f);

        return allFields;
    }
    public static Set<Method> getAllMethods(Object obj){
        Method[] declaredFields = obj.getClass().getDeclaredMethods();
        Method[] fields = obj.getClass().getMethods();

        Set<Method> allMethods = new HashSet<>();

        for(Method m : declaredFields) allMethods.add(m);
        for(Method m : fields) allMethods.add(m);

        return allMethods;
    }
    public static Collection<String> fieldCollection(Object obj){
        Set<Field> allFields = getAllFields(obj);

        Collection<String> result = new ArrayList<>();

        for(Field f : allFields)
            result.add(f.getName());

        return result;
    }

    public static void lineConnector(Line a, Line b) throws NoSuchFieldException, IllegalAccessException{
        Field startField = a.getClass().getDeclaredField("start");
        Field endField = a.getClass().getDeclaredField("end");

        startField.setAccessible(true);
        endField.setAccessible(true);

        startField.set(b, endField.get(a));
    }

    public static void testSomeClass(Object object, Class testClass){
        Method[] testSet = testClass.getDeclaredMethods();

        for (Method m : testSet){
            try{
                m.invoke(null, object);
            }
            catch(InvocationTargetException ex){
                System.out.println(ex.getCause());
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public static String serialise(Object object){
        Set<Field> allFields = MyUtils.getAllFields(object);

        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(object.getClass().getSimpleName());
        stringBuilder.append("(");
        int position = 0;
        for (Field f : allFields) {
            try {
                f.setAccessible(true);
                Object value = f.get(object);

                stringBuilder.append(f.getName())
                        .append(" = ")
                        .append(value.toString());

                position++;

                if(position < allFields.size())
                    stringBuilder.append(", ");
            }
            catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            finally {
                f.setAccessible(false);
            }
        }
        stringBuilder.append(")");

        return stringBuilder.toString();
    }


}
