package com.epam.msfrolov.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
    ;

    public static <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return applicationContext.getBean(s, aClass);
    }

}
