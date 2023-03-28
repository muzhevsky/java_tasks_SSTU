package com.muzhevsky.core.utils.defaultHandling;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

import static com.muzhevsky.core.utils.MyUtils.collect;


public class DefaultHandler {
    public static void reset(Class config, Object... objects) throws Exception {
        for (Object o : objects) {
            var defaults = collect(config);
            var fields = getAllFields(o.getClass());
            if (o.getClass().isAnnotationPresent(Default.class)) {
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

    public static Field getField(Collection<Field> fields, String name) {
        for (var f : fields) {
            f.setAccessible(true);
            if (f.getName() == name) {
                f.setAccessible(false);
                return f;
            }
            f.setAccessible(false);
        }
        return null;
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