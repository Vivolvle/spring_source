package com.vivolvle.config;

import com.vivolvle.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类==配置文件
 *
 * @author weilz
 * @date 2019/10/5
 */
@Configuration
//@ComponentScan(value = "com.vivolvle", excludeFilters = {
//        //排除controller和Service注解的bean
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//})
@ComponentScan(value = "com.vivolvle", includeFilters = {
//        //排除controller和Service注解的bean
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//        //按照指定的类型
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
        //自定义类型
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
}, /** 让默认过滤不生效，includeFilters方可奏效 */useDefaultFilters = false)
public class MainConfig {

    /**
     * id 默认使用方法名,或者指定value
     *
     * @return
     */
    @Bean("person")
    public Person person01() {
        return new Person("李四", 20,"小李四");
    }
}
