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

    Map objects = new HashMap<String, Object>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for(Field field : getAllFields(bean.getClass())){
            if (field.getName() == "name") {
                objects.put(beanName, bean);
                return bean;
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (!objects.containsKey(beanName)) return bean;
        for(Field field : getAllFields(bean.getClass())){
            if (field.getName() == "name") {
                field.setAccessible(true);
                try {
                    field.set(objects.get(beanName), "vasya");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(false);
            }
        }

        return bean;
    }
}
