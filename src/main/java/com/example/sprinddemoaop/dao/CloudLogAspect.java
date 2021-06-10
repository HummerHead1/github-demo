package com.example.sprinddemoaop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {
    @Before("com.example.sprinddemoaop.dao.PointCutAspect.accountDaoMethods()")
    public void cloudLogAdvvice(){
        System.out.println("Advice method BEFORE for CLOUD!");
    }
}
