package com.vivolvle;

import com.vivolvle.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 10:22
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        //创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        context.close();
    }
}
