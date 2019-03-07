package com.example.demo.annotation.aop_test;

import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器接口
 */
public interface Interceptor {
    boolean before();
    void after();
    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
    void afterReturning();
    void afterThrowing();
    boolean useAround();

}
