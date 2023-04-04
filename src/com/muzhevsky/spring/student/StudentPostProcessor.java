package com.muzhevsky.spring.student;

import com.muzhevsky.core.student.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class StudentPostProcessor implements BeanPostProcessor {
    @Autowired
    @Qualifier("predicate")
    @Lazy
    Predicate<Integer> range;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student){
            Student student = (Student)bean;
            student.setMarkChecker(range);
            List<Integer> marks = student.getMarks();
            for(int i = 0; i < marks.size(); i++){
                if (!range.test(marks.get(i))) throw new IllegalArgumentException("wrong marks");
            }
        }

        return bean;
    }
}
