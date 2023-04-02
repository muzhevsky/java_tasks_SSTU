package com.muzhevsky.spring.utils.toString;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.Predicate;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

public class Entity {
    @Override
    public final String toString() {
        Set<Field> allFields = getAllFields(getClass());

        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(getClass().getName())
                .append("(");



        if (this.getClass().isAnnotationPresent(ToString.class)
                && this.getClass().getAnnotation(ToString.class).value() == ToStringParameter.NO)
            return this.getClass().toString();

        Predicate<Field> fieldAnnotationChecker = (field) -> {
            return !field.isAnnotationPresent(ToString.class) ||
                    field.getAnnotation(ToString.class).value() == ToStringParameter.NO;
        };

        for (Field f : allFields) {
            try {
                f.setAccessible(true);
                if (fieldAnnotationChecker.test(f)) continue;

                Object value = f.get(this);

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
}
