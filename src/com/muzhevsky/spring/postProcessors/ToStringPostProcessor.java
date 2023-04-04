package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.utils.toString.ToStringMethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import static com.muzhevsky.spring.utils.MyUtils.*;

@Component
public class ToStringPostProcessor implements BeanPostProcessor {
    Map<String, Object> objects = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        objects.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Enhancer enhancer = new Enhancer();
        Class<?> clazz = bean.getClass();
//        if (Modifier.isFinal(clazz.getModifiers())) return bean;
//        if (!hasDefaultConstructor(clazz)) return bean;

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new ToStringMethodInterceptor());

        Object proxy = enhancer.create();
        for(Field field : getAllFields(clazz)){
            if (Modifier.isFinal(field.getModifiers())) continue;
            field.setAccessible(true);
            try {
                field.set(proxy, field.get(bean));
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }

        return bean;
    }
}
