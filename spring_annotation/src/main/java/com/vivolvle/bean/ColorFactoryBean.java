package com.vivolvle.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author liangzheng.wei
 * @Description: 创建一个spring定义的FactoryBean
 * @date 2019/10/11 20:48
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     *
     * @return 返回一个Color对象，这个对象会添加到容器中
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean....getObject....");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
