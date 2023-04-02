package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.utils.toString.Entity;
import com.muzhevsky.spring.utils.toString.ToString;
import com.muzhevsky.spring.utils.toString.ToStringHandler;
import com.muzhevsky.spring.utils.toString.ToStringParameter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static com.muzhevsky.spring.utils.MyUtils.getAllFields;

@Component
public class ToStringPostProcessor implements BeanPostProcessor {
    Map objects = new HashMap<String, Object>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ToString.class))
            objects.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!objects.containsKey(beanName)) return bean;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(new ToStringHandler());
        Object proxy = enhancer.create();

        for(Field field : getAllFields(bean.getClass())){
            field.setAccessible(true);
            try {
                field.set(proxy, field.get(bean));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return bean.getClass().cast(proxy);
    }
}
