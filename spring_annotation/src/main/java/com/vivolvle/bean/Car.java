package com.vivolvle.bean;

import org.springframework.stereotype.Component;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 10:20
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@Component
public class Car {
    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car ... init ...");
    }

    public void destroy(){
        System.out.println("car destroy");
    }
}
