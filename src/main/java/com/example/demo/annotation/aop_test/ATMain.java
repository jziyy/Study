package com.example.demo.annotation.aop_test;

public class ATMain {
    public static void main(String[] args) {

        ATHelloService proxy = (ATHelloService) ProxyBean.getProxyBean(new ATHelloServiceImpl(),new MyInterceptor());
        proxy.sayHello("aaa");
    }
}
