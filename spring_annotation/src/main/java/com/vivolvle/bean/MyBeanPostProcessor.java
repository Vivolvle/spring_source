package com.vivolvle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author liangzheng.wei
 * @Description: 后置处理器，初始化前后处理，将后置处理器，放入到ioc中
 * @date 2019/10/12 14:09
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization...." + beanName + " => " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization...." + beanName + " => " + bean);
        return bean;
    }
}
