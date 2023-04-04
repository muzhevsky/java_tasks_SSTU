package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.cache.CacheMethodInterceptor;
import com.muzhevsky.spring.cache.Cache;
import com.muzhevsky.spring.toString.MyToString;
import com.muzhevsky.spring.toString.ToString;
import com.muzhevsky.spring.toString.ToStringHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
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
        Class<?> clazz = realObject.getClass();

        if (!clazz.isAnnotationPresent(Cache.class))
            return bean;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CacheMethodInterceptor());

        Object proxy = enhancer.create();

        for(Field field : getAllFields(clazz)){
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
