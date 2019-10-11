package com.vivolvle.condition;

import com.vivolvle.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liangzheng.wei
 * @Description: 手动注册bean到容器中
 * @date 2019/10/11 20:38
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata 当前类的注解信息
     * @param registry               定义的注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean yellow = registry.containsBeanDefinition("com.vivolvle.bean.Yellow");
        boolean blue = registry.containsBeanDefinition("com.vivolvle.bean.Blue");
        if (yellow && blue) {
            //指定bean名
            registry.registerBeanDefinition("rainbow", new RootBeanDefinition(Rainbow.class));
        }
    }
}
