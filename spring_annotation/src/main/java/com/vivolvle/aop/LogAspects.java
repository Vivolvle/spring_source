package com.vivolvle.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author weilz
 * @date 2019/10/26
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式   切所有方法，带两个参数
    //如果非本类的要使用这个切点，需要这个方法的全路径
    @Pointcut("execution(public int com.vivolvle.aop.MathCalculator.*(..))")
    public void pointCut() {

    }

    //不使用pointCut
    //@Before("public int com.vivolvle.aop.MathCalculator.*(..)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        //参数列表
        Object[] args = joinPoint.getArgs();
        //方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + ",参数列表是{" + Arrays.asList(args) + "}");
    }

    @After("com.vivolvle.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " 方法结束");
    }

    //joinPoint一定要出现在参数的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + " 正常返回，结果为: {" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        System.out.println(joinPoint.getSignature().getName() + " 异常,异常信息{" + ex.getMessage() + "}");
    }
}
