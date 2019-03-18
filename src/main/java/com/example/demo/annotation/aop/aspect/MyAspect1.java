package com.example.demo.annotation.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect1 {

////Aop_UserNameVaidateImpl
//    @DeclareParents(value = "com.example.demo.annotation.aop.service.Aop_UserServiceImpl",defaultImpl = Aop_UserNameVaidateImpl.class)
//    public Aop_UserNameValidate aop_userNameValidate;
//
//    @DeclareParents(value = "com.example.demo.annotation.aop.service.Aop_UserServiceImpl",defaultImpl = Aop_UserValidateImpl.class)
//    public Aop_UserValidate aop_userValidate;

    @Pointcut("execution(* com.example.demo.annotation.aop.service.Aop_UserService.printUser(..))")
    public void pointCut(){

    }
    @Around("pointCut()")
    public boolean around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        boolean a = (boolean) proceedingJoinPoint.proceed();
        System.out.println("around after");
        return a;
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after");
    }

    @AfterReturning("pointCut()")
    public void afterreturning(){
        System.out.println("afterreturn");
    }

    @AfterThrowing("pointCut()")
    public void afterthrow(){
        System.out.println("抛异常了");
    }
}
