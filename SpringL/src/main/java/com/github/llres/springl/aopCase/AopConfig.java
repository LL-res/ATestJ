package com.github.llres.springl.aopCase;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Aspect
@Service
@Slf4j
//顺序
//Around.class, Before.class, After.class, AfterReturning.class, AfterThrowing.class。
//相同类型的切面比函数名称
public class AopConfig {
    @Before("execution(* com.github.llres.springl.aopCase.AdminUserService.login())")
    public void beforeAdminLogin1(JoinPoint pjp) throws Throwable {
        System.out.println("pure before AdminLogin aop 1");
    }

    @Before("execution(* com.github.llres.springl.aopCase.AdminUserService.login())")
    public void beforeAdminLogin2(JoinPoint pjp) throws Throwable {
        System.out.println("pure before AdminLogin aop 2");
    }

    @Around("execution(* com.github.llres.springl.aopCase.AdminUserService.login())")
    public Object aroundAdminLogin(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before AdminLogin aop ");
        pjp.proceed();
        System.out.println("around after AdminLogin aop  ");
        return null;
    }

    @After("execution(* com.github.llres.springl.aopCase.AdminUserService.login())")
    public void afterAdminLogin(JoinPoint pjp) throws Throwable {
        System.out.println("pure after AdminLogin aop  ");
    }
}
