package com.vivolvle;

import com.vivolvle.bean.Person;
import com.vivolvle.config.MainConfig;
import com.vivolvle.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author weilz
 * @date 2019/10/5
 */
public class IOCTest {
    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeans(context);
        Object object1 = context.getBean("person");
        Object object2 = context.getBean("person");
        System.out.println(object1 == object2);
    }

    @Test
    public void test03() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String property = context.getEnvironment().getProperty("os.name");
        System.out.println(property);
//        String[] beanDefinitionNames = context.getBeanNamesForType(Person.class);
//        for (String name : beanDefinitionNames) {
//            System.out.println(name);
//        }
        Map<String, Person> person = context.getBeansOfType(Person.class);
        System.out.println(person);
    }

    @Test
    public void testImport(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeans(context);
    }

    private void printBeans(ApplicationContext context){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
