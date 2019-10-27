package com.vivolvle;

import com.vivolvle.aop.MathCalculator;
import com.vivolvle.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author weilz
 * @date 2019/10/27
 */
public class IOCTest_AOP {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator calculator = context.getBean(MathCalculator.class);
        calculator.div(1,1);
        context.close();
    }
}
