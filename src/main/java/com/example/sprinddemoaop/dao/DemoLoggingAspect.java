package com.example.sprinddemoaop.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {

    @Before("com.example.sprinddemoaop.dao.PointCutAspect.accountDaoMethods()")
    public void beforeAddAccountLogging(JoinPoint joinPoint) {
        System.out.println("Advice method BEFORE!");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println(signature);

        Object[] args = joinPoint.getArgs();
        for (Object a : args) {
            System.out.println(a);
            if (a instanceof Account) {
                Account account = (Account) a;
                System.out.println(((Account) a).getName());
                System.out.println(((Account) a).getLevel());
            }
        }

    }

}
