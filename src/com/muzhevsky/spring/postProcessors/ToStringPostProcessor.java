package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.toString.ToString;
import com.muzhevsky.spring.toString.ToStringMethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

//@Component
public class ToStringPostProcessor implements BeanPostProcessor {
    Map<String, Object> objects = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ToString.class))
            objects.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!objects.containsKey(beanName)) return bean;
        var realObject = objects.get(beanName);
        Enhancer enhancer = new Enhancer();
        Class<?> clazz = realObject.getClass();

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new ToStringMethodInterceptor());

        Object proxy = enhancer.create();
        for (Field field : getAllFields(clazz)) {
            if (Modifier.isFinal(field.getModifiers())) continue;
            field.setAccessible(true);
            try {
                field.set(proxy, field.get(bean));
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }

//        Object proxy = Proxy.newProxyInstance(realObject.getClass().getClassLoader(), new Class[]{ToString.class}, new ToStringHandler());


        return proxy;
    }
}
