package com.vivolvle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 10:34
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat ...afterPropertiesSet....");
    }
}
