package com.muzhevsky.core.utils;

import com.muzhevsky.core.geometry.Line;
import com.muzhevsky.core.utils.annotations.Invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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


    // сделать статическое поле - список полей с отложенной инициализацией и каждую итерацию проверять, можно ли заполнить
    public static Map<String, Object> collect(Collection<Class> classes) throws Exception{
        var result = new HashMap<String, Object>();

        for (var clazz : classes){
            for (var method : getAllMethods(clazz)){
                if (method.getAnnotation(Invoke.class) == null) continue;

                method.setAccessible(true);
                String name = method.getReturnType().getName();
                Object methodResult = null;
                if (method.getParameterCount() == 0) {
                    methodResult = method.invoke(clazz.newInstance());
                    result.put(name, methodResult);
                }
            }
        }

        return result;
    }
}
