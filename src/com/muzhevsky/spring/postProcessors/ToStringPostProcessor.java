package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.utils.CacheMethodInterceptor;
import com.muzhevsky.spring.utils.annotations.Cache;
import com.muzhevsky.spring.utils.toString.ToString;
import com.muzhevsky.spring.utils.toString.ToStringMethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;
import static com.muzhevsky.spring.utils.MyUtils.getAllMethods;

@Component
public class ToStringPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Enhancer enhancer = new Enhancer();
        Class clazz = bean.getClass();
        Class originClass = ClassUtils.getUserClass(clazz);
        if (Modifier.isFinal(clazz.getModifiers()) || !originClass.isAnnotationPresent(ToString.class)) return bean;

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new ToStringMethodInterceptor());

        var test = getAllMethods(clazz);

        try {
            Object proxy = enhancer.create();
            for(Field field : getAllFields(clazz)){
                field.setAccessible(true);
                try {
                    field.set(proxy, field.get(bean));
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
            }

            return proxy;
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        return null;
    }
}
