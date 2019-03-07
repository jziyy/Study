package com.example.demo.annotation.aop_test;


import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Getter
@Setter
public class Invocation {
    private Object [] params;
    private Method method;
    private Object target;

    public Invocation(Object target,Method method,Object[] params){
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,params);
    }
}
