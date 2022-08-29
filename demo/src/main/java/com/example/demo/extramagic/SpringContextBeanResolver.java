package com.example.demo.extramagic;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.http.HttpSession;

public class SpringContextBeanResolver implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    // By type (unused)
    public static <T> T getBean(Class<T> beanClass) {
        return CONTEXT.getBean(beanClass);
    }

    public static boolean foo() {
        return true;
    }


    // By name
    public static Object getBean(String beanName) {
        if(foo()) {
            beanName = "OtherBean";
            //beanName += "OtherBeanRelated (Service, Repo, Config...)"
        }
        return CONTEXT.getBean(beanName);
    }

}
