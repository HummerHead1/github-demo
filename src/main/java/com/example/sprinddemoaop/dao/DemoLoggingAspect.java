package com.example.sprinddemoaop.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @AfterReturning(pointcut = "com.example.sprinddemoaop.dao.PointCutAspect.afterAllAccounts()", returning = "accounts")
    public void printAllAccounts(JoinPoint joinPoint, List<Account> accounts) {
        for (Account a : accounts) {
            System.out.println(a.getName() + " - " + a.getLevel());
        }
        Account a = accounts.get(0);
        a.setName("Daffy Duck");
    }

    @After("com.example.sprinddemoaop.dao.PointCutAspect.afterfindAllSilverAccounts()")
    public void firstAccount(JoinPoint joinPoint) {
        System.out.println("Method signature : " + joinPoint.getSignature().toShortString());
    }
}