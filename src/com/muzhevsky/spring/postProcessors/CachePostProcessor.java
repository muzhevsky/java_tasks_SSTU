package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.cache.CacheMethodInterceptor;
import com.muzhevsky.spring.cache.Cache;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

@Component
public class CachePostProcessor implements BeanPostProcessor {
    Map<String, Object> objects = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        objects.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var realObject = objects.containsKey(beanName) ? objects.get(beanName) : bean;

        Enhancer enhancer = new Enhancer();
        Class<?> clazz = realObject.getClass();

        if (Modifier.isFinal(bean.getClass().getModifiers()) || !bean.getClass().isAnnotationPresent(Cache.class))
            return bean;

        enhancer.setSuperclass(clazz);
        var test = new CacheMethodInterceptor();
        enhancer.setCallback(test);

        Object proxy = enhancer.create();

        for(Field field : getAllFields(bean.getClass())){
            field.setAccessible(true);
            try {
                field.set(proxy, field.get(bean));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return proxy;
    }
}
