package com.vivolvle.bean;

import org.springframework.stereotype.Component;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 15:39
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@Component
public class Boss {
    private Car car;
    private Blue blue;

//    @Autowired
    public Boss(Car car,Blue blue){
        this.car = car;
        this.blue = blue;
    }

//    public Car getCar() {
//        return car;
//    }
//
//    @Autowired //标注在方法上，Spring容器创建对象，就会调用方法
//    //方法使用的参数，自定义类型的值从ioc容器中获取
//    public void setCar(Car car) {
//        this.car = car;
//    }


    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                ", blue=" + blue +
                '}';
    }
}
