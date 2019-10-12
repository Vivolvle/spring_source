package com.vivolvle.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author weilz
 * @date 2019/10/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    //使用@Value注解,还可以使用${}，取出配置文件中的值（在运行环境变量中的值）
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;
}
