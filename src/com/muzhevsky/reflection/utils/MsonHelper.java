package com.muzhevsky.reflection.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.muzhevsky.reflection.utils.MyUtils.getAllFields;
import static com.muzhevsky.reflection.utils.MyUtils.getFieldFromAllFields;

public class MsonHelper {
    public static String serialise(Object object) {
        Set<Field> allFields = getAllFields(object.getClass());

        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(object.getClass().getName())
                .append("(");

        for (Field f : allFields) {
            try {
                f.setAccessible(true);
                Object value = f.get(object);

                stringBuilder.append(f.getName())
                        .append("=");

                if (value == null) stringBuilder.append("null");
                else stringBuilder.append(value.toString());

                stringBuilder.append(";");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } finally {
                f.setAccessible(false);
            }
        }
        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    public static Object deserialise(char[] str, int position) throws Exception {
        StringBuilder currentString = new StringBuilder(16);
        Object result = null;
        Field field = null;
        while (position < str.length) {
            if (str[position] == '(') {
                position++;
                Class resultClass = Class.forName(currentString.toString());
                Constructor constructor = resultClass.getDeclaredConstructor();
                result = constructor.newInstance();
                currentString.delete(0, currentString.length());
                position = deserialiseHelper(result, str, position);
            }

            if (position >= str.length - 1) return result;

            currentString.append(str[position]);
            position++;
        }
        return result;
    }

    private static int deserialiseHelper(Object object, char[] str, int position) throws Exception {
        StringBuilder currentString = new StringBuilder(16);
        Field field = null;
        Set<Field> allFields = getAllFields(object.getClass());
        while (position < str.length && str[position] != ')') {

            if (str[position] == '=') {
                position++;
                field = getFieldFromAllFields(object.getClass(), currentString.toString());
                currentString.delete(0, currentString.length());
            }

            if (str[position] == '(') {
                position++;
                Class resultClass = Class.forName(currentString.toString());
                Object value = resultClass.newInstance();

                int offset = deserialiseHelper(value, str, position);
                position = offset;
                field.set(object, value);
                currentString.delete(0, currentString.length());
            }


            if (str[position] == ';') {
                if (field!=null) {
                    MsonHelper.tryParseString(currentString.toString(), field, object);
                    field = null;
                }

                currentString.delete(0, currentString.length());
                position++;
            }

            if (position >= str.length)
                return str.length - 1;

            if (str[position] == ')')
                return position + 1;

            currentString.append(str[position]);
            position++;

        }
        return position;
    }

    private static boolean tryParseString(String value, Field field, Object object){
        field.setAccessible(true);
        Class type = field.getType();

        try {
            if (type.equals(String.class))
                field.set(object, value);

            else if (type.equals(int.class) || type.equals(Integer.class))
                field.set(object, Integer.parseInt(value));

            else if (type.equals(float.class) || type.equals(Float.class))
                field.set(object, Float.parseFloat(value));

            else if (type.equals(double.class) || type.equals(Double.class))
                field.set(object, Double.parseDouble(value));

            else if (type.equals(boolean.class) || type.equals(Boolean.class))
                field.set(object, Boolean.parseBoolean(value));

            // грустно...
//            else {
//                List<Class> primitives = new ArrayList<>();
//
//                primitives.add(Double.class);
//                primitives.add(Float.class);
//                primitives.add(Boolean.class);
//
//                for (Class clazz : primitives)
//                    clazz.getMethod("parse" + clazz.getSimpleName()).invoke(value);
//            }
        }
        catch (Exception ex){
            return false;
        }

        field.setAccessible(false);
        return true;
    }
}
