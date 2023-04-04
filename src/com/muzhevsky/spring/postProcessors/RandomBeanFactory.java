package com.muzhevsky.spring.postProcessors;

import com.muzhevsky.spring.random.MyRandom;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomBeanFactory implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        if (registry.containsBeanDefinition("random")) return;
        registry.registerBeanDefinition("random", BeanDefinitionBuilder.genericBeanDefinition(MyRandom.class).getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(((MyRandom)beanFactory.getBean("random")).getRandom());
        System.out.println(((MyRandom)beanFactory.getBean("random")).getRandom());
        System.out.println(((MyRandom)beanFactory.getBean("random")).getRandom());
        System.out.println(((MyRandom)beanFactory.getBean("random")).getRandom());
    }
}
