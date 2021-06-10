package com.example.sprinddemoaop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalyticsAspect {

    @Before("com.example.sprinddemoaop.dao.PointCutAspect.accountDaoMethods()")
    public void apiAnalyticsAdvice(){
        System.out.println("Advice method BEFORE for ANALYTICS!");
    }
}
