package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.utils.annotations.Validate;
import com.muzhevsky.spring.utils.test.ValidateException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class ValidatePostProcessor implements BeanPostProcessor {
    Map<String, Object> objects = new HashMap<>();
    @Autowired
    ApplicationContext ctx;

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        objects.put(beanName, bean);
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object realObject = objects.containsKey(beanName) ? objects.get(beanName) : bean;
        if (!realObject.getClass().isAnnotationPresent(Validate.class)) return bean;
        String[] testContainer = realObject.getClass().getAnnotation(Validate.class).value();
        if (testContainer == null) throw new ValidateException("there is no tests for this object");

        for (String test : testContainer) {
            if (test == null) throw new ValidateException("invalid test");

            Object testObject = ctx.getBean(test);

            Method[] tests = testObject.getClass().getDeclaredMethods();
            for (var method : tests) {
                try {
                    method.invoke(testObject.getClass().newInstance(), realObject);
                } catch (InvocationTargetException ex) {
                    throw new ValidateException(ex.getCause().getMessage());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("VALIDATION: OK");
        return bean;
    }
}
