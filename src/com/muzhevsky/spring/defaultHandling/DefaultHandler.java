package com.muzhevsky.spring.defaultHandling;

import com.muzhevsky.spring.utils.MyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;


public class DefaultHandler {
    public static void reset(Object... objects) throws Exception {
        for (Object o : objects) {
            Set<Field> fields = getAllFields(o.getClass());
            Map<Type, Object> defaults = null;
            if (o.getClass().isAnnotationPresent(Default.class)) {
                //Class config = o.getClass().getAnnotation(Default.class).value();
                //defaults = MyUtils.collect(config);
                for (var f : fields) {
                    if (f.getType().isPrimitive()) continue;
                    else resetHelper(f, o, defaults);
                }
            }

            for (var f : fields) {
                if (f.getType().isPrimitive()) continue;
                if (f.isAnnotationPresent(Default.class)) {
                    resetHelper(f, o, defaults);
                }
            }
        }
    }

    private static void resetHelper(Field field, Object obj, Map<Type, Object> config) throws Exception {
        field.setAccessible(true);
        field.set(obj, config.get(field.getType()));
        field.setAccessible(false);
    }

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
}