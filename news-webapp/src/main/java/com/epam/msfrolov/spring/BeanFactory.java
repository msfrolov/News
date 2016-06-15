package com.epam.msfrolov.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

public class BeanFactory {

    //    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
//    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WebappConfiguration.class);
    private static ApplicationContext applicationContext = null;


    public static <T> T getBean(String s, Class<T> clazz) throws BeansException {
        return applicationContext.getBean(s, clazz);
    }

    public static Object getBean(String s) throws BeansException {
        return applicationContext.getBean(s);
    }

    public static <T> T getBean(Class<T> aClass) throws BeansException {
        return applicationContext.getBean(aClass);
    }

    public static boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(s);
    }

    public static boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.isPrototype(s);
    }

    public static Class<?> getType(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(s);
    }

    public static String[] getAliases(String s) {
        return applicationContext.getAliases(s);
    }
}
