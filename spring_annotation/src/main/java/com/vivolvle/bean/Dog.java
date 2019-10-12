package com.vivolvle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 12:01
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class Dog {
    public Dog(){
        System.out.println("dog..");
    }

    //对象创建并赋值之后
    @PostConstruct
    public void init(){
        System.out.println("dog....PostConstruct...");
    }

    //销毁对象
    @PreDestroy
    public void destroy(){
        System.out.println("dog...PreDestroy...");
    }

}
