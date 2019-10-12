package com.vivolvle;

import com.vivolvle.bean.Person;
import com.vivolvle.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 14:38
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class IOCTest_PropertyValues {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01() {
        printBeans(context);
        System.out.println("=============");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        ConfigurableEnvironment environment = context.getEnvironment();
        String value = environment.getProperty("person.nickName");
        System.out.println("value:======>" + value);
        //创建ioc容器
        context.close();
    }

    private void printBeans(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
