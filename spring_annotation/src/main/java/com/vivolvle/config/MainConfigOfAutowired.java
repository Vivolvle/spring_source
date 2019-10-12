package com.vivolvle.config;

import com.vivolvle.bean.Car;
import com.vivolvle.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangzheng.wei
 * @Description: 自动装配：
 *      1：Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系的赋值
 *      如果容器中组件有多个，根据名字来到ioc容器中找
 *      可以用@Qualifier,指定从ioc中获取特定名称的bean
 *      用@Primary，决定哪个Bean被首选，可以打在@Bean或者@Component上
 *      2：Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范注解]
 *          Resource:默认按照属性名称进行装配，没有Primary支持，可以使用@Resource(name = "")
 *          Inject：需加入maven依赖,没有required = false的功能
 *      3:@Autowired 构造器，参数，方法，属性都可以标注@Autowired
 *      1):[标注在方法位置]，@Bean+方法参数，参数从容器中获取，默认不加@Autowired
 *      2):[标在构造器上]，如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从ioc容器中获取
 *      3):放在参数位置
 * @date 2019/10/12 14:56
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@Configuration
@ComponentScan({"com.vivolvle.service","com.vivolvle.dao","com.vivolvle.bean"})
public class MainConfigOfAutowired {

    /**
     * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
