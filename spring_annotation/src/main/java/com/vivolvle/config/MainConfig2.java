package com.vivolvle.config;

import com.vivolvle.bean.Color;
import com.vivolvle.bean.ColorFactoryBean;
import com.vivolvle.bean.Person;
import com.vivolvle.condition.LinuxCondition;
import com.vivolvle.condition.MyImportBeanDefinitionRegistrar;
import com.vivolvle.condition.MyImportSelector;
import com.vivolvle.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author weilz
 * @date 2019/10/5
 */
@Configuration
//类中配置统一设置，满足当前条件，这个config中的所有配置才会生效
@Conditional(WindowsCondition.class)
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})    //可以传数组
public class MainConfig2 {
    //默认单实例

    /**
     * @return
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  ioc启动并不会去调用方法创建对象。而是每次获取的时候才会调用方法创建对象
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON  ioc容器启动会调用方法创建对象放到ioc容器中，
     * 以后每次请求到容器中拿（map.get()）
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST 同一次请求创建一个实例
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION 同一个session创建一个实例
     * <p>
     * 懒加载：
     * 单实例bean：默认在容器启动的创建对象 @Lazy
     */
    @Lazy
//    @Scope("prototype")
    @Bean
    public Person person() {
        return new Person("张三", 19);
    }

    /**
     * @Conditional,按照一定的条件进行判断，满足条件给容器中注册bean
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("bill", 20);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 30);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
