package com.vivolvle;

import com.vivolvle.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 14:38
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class IOCTest_Profile {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

    //设置jvm参数
    @Test
    public void test01() {
        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        context.close();
    }

    //配置context
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dev","test");
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        applicationContext.close();
    }

    private void printBeans(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
