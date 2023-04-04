package com.muzhevsky.spring.utils;

import com.muzhevsky.core.geometry.Line;
import com.muzhevsky.spring.utils.annotations.Invoke;
import com.muzhevsky.spring.utils.annotations.Validate;
import com.muzhevsky.spring.utils.test.ValidateException;

import java.lang.reflect.*;
import java.util.*;

public abstract class MyUtils {
    public static Set<Field> getAllFields(Class cl) {
        Field[] declaredFields = cl.getDeclaredFields();
        Field[] fields = cl.getFields();

        Set<Field> allFields = new HashSet<>();

        for (Field f : declaredFields) allFields.add(f);
        for (Field f : fields) allFields.add(f);

        if (cl.getSuperclass() != Object.class) {
            allFields.addAll(getAllFields(cl.getSuperclass()));
        }

        return allFields;
    }

    public static Set<Method> getAllMethods(Class cl) {
        Method[] declaredFields = cl.getDeclaredMethods();
        Method[] fields = cl.getMethods();

        Set<Method> allMethods = new HashSet<>();

        for (Method m : declaredFields) allMethods.add(m);
        for (Method m : fields) allMethods.add(m);

        return allMethods;
    }

    public static Collection<String> fieldCollection(Object obj) {
        Set<Field> allFields = getAllFields(obj.getClass());

        Collection<String> result = new ArrayList<>();

        for (Field f : allFields)
            result.add(f.getName());

        return result;
    }

    public static void lineConnector(Line a, Line b) throws NoSuchFieldException, IllegalAccessException {
        Field startField = a.getClass().getDeclaredField("start");
        Field endField = a.getClass().getDeclaredField("end");

        startField.setAccessible(true);
        endField.setAccessible(true);

        startField.set(b, endField.get(a));
    }

    public static void testSomeClass(Object object, Class testClass) {
        Method[] testSet = testClass.getDeclaredMethods();

        for (Method m : testSet) {
            try {
                m.invoke(null, object);
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(ex.getCause());
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    public static Field getFieldFromAllFields(Class clazz, String name) throws NoSuchFieldException {
        Collection<Field> fields = getAllFields(clazz);
        for (Field field : fields) {
            if (field.getName().equals(name)) return field;
        }

        throw new NoSuchFieldException("there's no " + name + " field in " + clazz.getName() + " class");
    }


    public static Map<Type, Object> collect(Class clazz) throws Exception {
        var result = new HashMap<Type, Object>();
        Object object = clazz.newInstance();
        for (var method : getAllMethods(clazz)) {
            if (method.getAnnotation(Invoke.class) == null) continue;
            Object[] parameters = new Object[method.getParameterCount()];
            int index = 0;
            for (Class c : method.getParameterTypes()) {
                for (Object o : result.values()) {
                    if (o.getClass().equals(c)) {
                        parameters[index] = o;
                        index++;
                        break;
                    }
                }
            }
            method.setAccessible(true);
            String name = method.getReturnType().getName();

            Object methodResult = method.invoke(clazz.newInstance(), parameters);
            result.put(method.getReturnType(), methodResult);
        }
        return result;
    }

//    public static void validate(Object object) throws Exception {
//        var testContainer = object.getClass().getAnnotation(Validate.class);
//        if (testContainer == null) throw new ValidateException("there is no tests for this object");
//
//        for (var testSet : testContainer.value()) {
//            var tests = testSet.getDeclaredMethods();
//            for (var test : tests) {
//                try {
//                    test.invoke(testSet.newInstance(), object);
//                }
//                catch (InvocationTargetException ex){
//                    throw new ValidateException(ex.getCause().getMessage());
//                }
//            }
//        }
//    }

    public static <T> T getValueOfNecessaryType(Object item, String fieldName) throws Exception{
        Class<?> clazz = item.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        if (field == null) field = clazz.getField(fieldName);

        field.setAccessible(true);

        T value;
        try {
            value = (T)(field.get(item));
        }
        catch (Exception ex){
            throw new ValidateException(fieldName+" is not valid");
        }
        finally {
            field.setAccessible(true);
        }

        return value;
    }

    public static boolean hasDefaultConstructor(Class<?> clazz) {
        for (Constructor constructor : clazz.getConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                return true;
            }
        }
        return false;
    }
}
