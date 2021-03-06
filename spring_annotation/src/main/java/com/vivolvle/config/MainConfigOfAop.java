package com.vivolvle.config;

import com.vivolvle.aop.LogAspects;
import com.vivolvle.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *  定义一个业务逻辑类，在业务逻辑运行的时候，将日志进行打印
 *  通知方法：
 *      1：前
 *      2：后 无论方法正常结束还是异常结束都会调用
 *      3：环绕
 *      4：返回通知
 *      5：异常通知
 *  给切面类的目标方法标注何时何地运行(通知注解)
 *  将切面类和业务逻辑类(目标方法所在类)，都加入到容器中
 *  告诉spring，哪个是切面类（给切面类上加个注解，@Aspect）
 *  配置类@EnableAspectJAutoProxy，开启基于注解的aop实现方式，效果等于xml中的开启方式
 *
 *
 *  AOP的原理
 *      @EnableAspectJAutoProxy
 *  1：@Import(AspectJAutoProxyRegistrar.class)，利用AspectJAutoProxyRegistrar自定义给容器中注册bean
 *      internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *      给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 *  2： AnnotationAwareAspectJAutoProxyCreator    （再来看这个组件功能是什么）
 *      ->AspectJAwareAdvisorAutoProxyCreator
 *          ->AbstractAdvisorAutoProxyCreator
 *              ->AbstractAutoProxyCreator implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *              关注后置处理器（在bean初始化前后做事情）,自动装配BeanFactory
 *  AbstractAutoProxyCreator.setBeanFactory()
 *  AbstractAutoProxyCreator 有后置处理器的逻辑
 *
 *  AbstractAdvisorAutoProxyCreator.setBeanFactory()->initBeanFactory()
 *
 *  AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 *
 *  流程:
 *      1)：传入配置类，创建ioc容器
 *      2：注册配置类，调用refresh()刷新容器
 *      3：registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 *          1）：先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 *          2）：给容器中加别的BeanPostProcessor
 *          3）：优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *          4）：在给容器中注册实现了Ordered接口的BeanPostProcessor
 *          5）：注册没有实现优先级接口的BeanPostProcessor
 *          6）：注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中
 *              创建internalAutoProxyCreator的BeanPostProcessor[AnnotationAwareAspectJAutoProxyCreator]
 *              1).创建Bean的实例
 *              2),populateBean(beanName,mbd,instanceWrapper);bean的各种属性赋值
 *              3),initializeBean，初始化bean
 *                  1）：invokeAwareMethods(),处理Aware接口的方法回调
 *                  2）：applyBeanPostProcessorsBeforeInitialization():应用后置处理器的BeforeInitialization
 *                  3）：invokeInitMethods():执行自定义的初始化的方法
 *                  4）：applyBeanPostProcessorsAfterInitialization():应用后置处理器的postProcessAfterInitialization
 *              4):BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功;-->aspectJAdvisorsBuilder
 *          7)：把BeanPostProcessor注册到BeanFactory中
 *====================以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程===================================
 * @see MainConfig2 同样使用了ImportBeanDefinitionRegistrar
 * @author weilz
 * @date 2019/10/26
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

    //将业务逻辑类加入到容器中
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    //切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
