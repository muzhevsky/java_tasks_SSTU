package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.utils.CacheMethodInterceptor;
import com.muzhevsky.spring.utils.annotations.Cache;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

@Component
public class CachePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Enhancer enhancer = new Enhancer();
        Class clazz = bean.getClass();

        if (Modifier.isFinal(clazz.getModifiers()) || !clazz.isAnnotationPresent(Cache.class)) return bean;

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CacheMethodInterceptor());

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
