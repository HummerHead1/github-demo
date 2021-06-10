package com.example.sprinddemoaop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutAspect {
    @Pointcut("execution(* com.example.sprinddemoaop.dao.*.*(..))")
    public void addMethods() {
    }

    @Pointcut("execution(* com.example.sprinddemoaop.dao.AccountDaoImpl.get*())")
    public void accountGetters() {
    }

    @Pointcut("execution(* com.example.sprinddemoaop.dao.AccountDaoImpl.set*(*))")
    public void accountSetters() {
    }

    @Pointcut("addMethods() && !accountGetters() && !accountSetters()")
    public void accountDaoMethods() {
    }

    @Pointcut("execution(* com.example.sprinddemoaop.dao.AccountDaoImpl.findAccounts())")
    public void afterAllAccounts() {
    }

    ;

    @Pointcut("execution(* com.example.sprinddemoaop.dao.AccountDaoImpl.findAllSilverAccounts())")
    public void afterfindAllSilverAccounts() {}
}
