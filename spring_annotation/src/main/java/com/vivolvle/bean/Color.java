package com.vivolvle.bean;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/11 20:28
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
