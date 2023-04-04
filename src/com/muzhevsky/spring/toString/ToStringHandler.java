package com.muzhevsky.spring.toString;

import com.muzhevsky.spring.cache.MethodInvocationData;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

public class ToStringHandler implements InvocationHandler {
    Map<MethodInvocationData, Object> _cachedData = new HashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.getName().equals("toString")) {
            return method.invoke(proxy, args);
        }

        if (proxy.getClass().isAnnotationPresent(ToString.class) &&
                proxy.getClass().getAnnotation(ToString.class).value() == ToStringParameter.NO)
            return proxy.getClass().toString();


        Set<Field> allFields = getAllFields(proxy.getClass());


        StringBuilder stringBuilder = new StringBuilder(32);
        if (Enhancer.isEnhanced(proxy.getClass())) {
            stringBuilder.append(ClassUtils.getUserClass(proxy))
                    .append("(");
        } else {
            stringBuilder.append(proxy.getClass().getName())
                    .append("(");
        }


        Predicate<Field> fieldAnnotationChecker =
                field -> !field.isAnnotationPresent(ToString.class) ||
                        field.getAnnotation(ToString.class).value() == ToStringParameter.NO;

        for (Field f : allFields) {
            try {
                f.setAccessible(true);
                if (fieldAnnotationChecker.test(f)) continue;

                Object value = f.get(proxy);

                stringBuilder.append(f.getName())
                        .append("=");

                if (value == null) stringBuilder.append("null");
                else stringBuilder.append(value);

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
