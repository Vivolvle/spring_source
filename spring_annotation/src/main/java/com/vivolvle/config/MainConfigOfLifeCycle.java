package com.vivolvle.config;

import com.vivolvle.bean.Car;
import com.vivolvle.bean.Cat;
import com.vivolvle.bean.Dog;
import com.vivolvle.bean.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangzheng.wei
 * @Description:
 * 1：bean的生命周期，自定义初始化和销毁方法 指定init-method和destroy-method
 * 2：通过让bean实现InitializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)
 * 3：可以使用JSR250，@PostConstruct,在bean创建完成并且属性赋值完成，@PreDestroy,在容器销毁bean之前通知我们进行清理工作
 * 4: BeanPostProcessor bean的后置处理器
 *  populateBean(beanName, mbd, instanceWrapper); 给bean进行属性赋值
 *  赋值完后进行初始化
 *  invokeInitMethods(beanName, wrappedBean, mbd); 方法前后调用一前一后方法
 * 遍历得到容器总所有的BeanPostProcessor，一旦返回null，跳出for循环，不会执行后面的BeanPostProcessor
 * Spring底层对BeanPostProcessor的使用：
 *      bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Asyn，xxx BeanPostProcessor；
 *
 * 初始化:
 *      对象创建完成，并赋值好，调用初始化方法
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法
 *
 * @date 2019/10/11 20:58
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
