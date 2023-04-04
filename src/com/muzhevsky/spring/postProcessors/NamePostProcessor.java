package com.muzhevsky.spring.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

@Component
public class NamePostProcessor implements BeanPostProcessor {
    Map<String, Object> objects = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Field field : getAllFields(bean.getClass()))
            if (field.getName().equals("name"))
                objects.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (!objects.containsKey(beanName)) return bean;

        Object realObject = objects.get(beanName);
        for (Field field : getAllFields(realObject.getClass())) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                try {
                    if (field.get(realObject) == null)
                        field.set(realObject, "vasya");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(false);
            }
        }

        return bean;
    }
}
