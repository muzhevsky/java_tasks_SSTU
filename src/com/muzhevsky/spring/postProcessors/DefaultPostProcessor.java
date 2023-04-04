package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.defaultHandling.Default;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

@Component
public class DefaultPostProcessor implements BeanPostProcessor {

    Map<String, Object> objects = new HashMap<>();
    @Autowired
    ApplicationContext ctx;

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Field field : getAllFields(bean.getClass())) {
            if (field.isAnnotationPresent(Default.class)) {
                objects.put(beanName, bean);
                break;
            }
        }

        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!objects.containsKey(beanName)) return bean;
        Object realObject = objects.get(beanName);

        for (Field field : getAllFields(realObject.getClass())) {
            if (field.isAnnotationPresent(Default.class)) {
                String defaultBean = field.getAnnotation(Default.class).value();
                field.setAccessible(true);
                try {
                    field.set(realObject, ctx.getBean(defaultBean));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (bean.getClass().isAnnotationPresent(Default.class)) {
            for (Method method : realObject.getClass().getDeclaredMethods()) {
                if (!method.getName().contains("Default")) continue;
                Class methodType = method.getReturnType();
                for (Field field : getAllFields(realObject.getClass())) {
                    if (field.getType() == methodType){
                        field.setAccessible(true);
                        method.setAccessible(true);
                        try {
                            field.set(realObject, method.invoke(realObject));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }

        return bean;
    }
}
