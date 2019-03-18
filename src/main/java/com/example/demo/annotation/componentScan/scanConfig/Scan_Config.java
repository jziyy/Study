package com.example.demo.annotation.componentScan.scanConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * ComponentScan 扫描时使用excludeFilter属性可以让扫描不扫描特定注解
 * */
@Configuration
//@ComponentScan(basePackages = "com.example.demo.annotation.componentScan.*",
//        excludeFilters = {@ComponentScan.Filter(classes = {Service.class})})
public class Scan_Config {

}
