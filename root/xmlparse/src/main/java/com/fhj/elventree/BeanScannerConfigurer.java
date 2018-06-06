package com.fhj.elventree;

import com.fhj.elventree.ann.Registration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class BeanScannerConfigurer implements BeanFactoryPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Object> a = beanFactory.getBeansWithAnnotation(Registration.class);
        a.forEach((key, value) -> {
                    Registration table = value.getClass().getAnnotation(Registration.class);
                    System.out.println("bean xml prase");
                    System.out.println(table.description());
                    System.out.println(table.service());
                    System.out.println(table.method());
                    System.out.println(table.version());
                    System.out.println("bean xml prase");
                }
        );
    }


}


