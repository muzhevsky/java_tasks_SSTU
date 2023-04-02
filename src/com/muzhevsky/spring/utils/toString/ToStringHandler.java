package com.muzhevsky.spring.utils.toString;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.function.Predicate;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

public class ToStringHandler implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName() != "toString") return method.invoke(obj, args);

        Set<Field> allFields = getAllFields(obj.getClass());


        StringBuilder stringBuilder = new StringBuilder(32);
        if (Enhancer.isEnhanced(obj.getClass())) {
            stringBuilder.append(ClassUtils.getUserClass(obj))
                    .append("(");
        }
        else {
            stringBuilder.append(obj.getClass().getName())
                    .append("(");
        }

        if (this.getClass().isAnnotationPresent(ToString.class)
                && this.getClass().getAnnotation(ToString.class).value() == ToStringParameter.NO)
            return this.getClass().toString();

        Predicate<Field> fieldAnnotationChecker =
                field -> !field.isAnnotationPresent(ToString.class) ||
                field.getAnnotation(ToString.class).value() == ToStringParameter.NO;

        for (Field f : allFields) {
            try {
                f.setAccessible(true);
                if (fieldAnnotationChecker.test(f)) continue;

                Object value = f.get(obj);

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
