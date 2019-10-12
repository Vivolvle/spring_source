package com.vivolvle.config;

import com.vivolvle.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 14:37
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
//PropertySource，获取配置文件中的属性，可以一次获取多个配置文件
@PropertySource(value = {"classpath:person.properties"},encoding = "GBK")
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
