package com.muzhevsky.reflection.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Set;

public class MsonHelper {
    public static String serialise(Object object){
        Set<Field> allFields = MyUtils.getAllFields(object.getClass());

        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(object.getClass().getName())
                .append("(");

        for (Field f : allFields) {
            try {
                f.setAccessible(true);
                Object value = f.get(object);

                stringBuilder.append(f.getName())
                        .append("=")
                        .append(value.toString());

                stringBuilder.append(";");
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

    public static Object deserialise(char[] str, int position) throws Exception{
        StringBuilder currentString = new StringBuilder(16);
        Object result = null;
        Field field = null;
        while(position < str.length){
            if (str[position] == '('){
                position++;
                Class resultClass = Class.forName(currentString.toString());
                Constructor constructor = resultClass.getDeclaredConstructor();
                result = constructor.newInstance();
                currentString.delete(0, currentString.length());
                deserialiseHelper(result, str, position);
            }
            currentString.append(str[position]);
            position++;
        }
        return result;
    }

    private static int deserialiseHelper(Object object, char[] str, int position) throws Exception{
        StringBuilder currentString = new StringBuilder(16);
        Field field = null;
        while(position < str.length && str[position] != ')'){
            if (str[position] == '='){
                position++;
                field = object.getClass().getField(currentString.toString());
                currentString.delete(0, currentString.length());
            }

            else if (str[position] == ';'){
                field.set(object, field.getType().cast(currentString.toString()));
                currentString.delete(0, currentString.length());
                field = null;
            }

            else if (str[position] == '('){
                Class resultClass = Class.forName(currentString.toString());
                Constructor constructor = resultClass.getDeclaredConstructor();
                Object value = constructor.newInstance();

                for(Field f : MyUtils.getAllFields(value.getClass())){
                    f.set(value, f.getClass().getConstructor().newInstance());
                }

                deserialiseHelper(value, str, ++position);
                field.set(object, field.getType().cast(value));
                currentString.delete(0, currentString.length());
            }

            currentString.append(str[position]);
            position++;
        }
        return position;
    }
}
