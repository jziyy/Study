package com.example.demo;

import com.example.demo.annotation.aop.bean.Aop_UserInfo;
import com.example.demo.annotation.aop.service.Aop_UserNameVaidateImpl;
import com.example.demo.annotation.aop.service.Aop_UserNameValidate;
import com.example.demo.annotation.aop.service.Aop_UserService;
import com.example.demo.annotation.aop.service.Aop_UserValidate;
import com.example.demo.annotation.bean.Bean_spring_other;
import com.example.demo.annotation.bean.Bean_user;
import com.example.demo.annotation.bean.Persion;
import com.example.demo.annotation.bean.UserBean;
import com.example.demo.annotation.componentScan.dao.Scan_Bean;
import com.example.demo.annotation.componentScan.dao.Scan_Controller;
import com.example.demo.annotation.conditional.ConditionalBean;
import com.example.demo.annotation.conditional.onproperty.PropertyPersion;
import com.example.demo.annotation.configurationproperties.ConfigurationPropertiesBean;
import com.example.demo.annotation.springel.ElBean;
import com.example.demo.annotation.value.Value_Bean1;
import com.example.demo.annotation.value.Value_bean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AnnotationTest extends DemoApplicationTests {
    @Autowired
    @Qualifier("userbean1")
    UserBean bean;

    @Autowired
    @Qualifier("userbean2")
    UserBean bean2;

    @Autowired
    @Qualifier("userbean1")
    UserBean bean1;


    @Autowired
    ConfigurationPropertiesBean configurationPropertiesBean;

    @Autowired
    ConditionalBean conditionalBean;

    @Autowired
    PropertyPersion conditionalOnpropertyBean;

    @Autowired
    Value_bean value_bean;

    @Autowired
    Scan_Bean scan_bean;

//    @Autowired
//    Scan_Service scan_service;
    @Autowired
    Bean_user bean_user;

    @Autowired
    Persion persion;

    @Autowired
    @Qualifier("jziYY")
    Persion jziYY;

    @Autowired
    Scan_Controller scan_controller;

    @Autowired
    Value_Bean1 value_bean1;

    @Autowired
    Value_Bean1 value_bean11;

    @Autowired
    Value_bean value_beana;

    @Autowired
    Bean_spring_other bean_spring_other;

    @Autowired
    ElBean elBean;



    @Autowired
    Aop_UserService aop_userService;


    @Test
    public void aopTest(){
        Aop_UserInfo aop_userInfo = new Aop_UserInfo();

        aop_userService.printUser(aop_userInfo);
//
//        Aop_UserValidate aop_userValidate = (Aop_UserValidate) aop_userService;
//        if (aop_userValidate.validate(aop_userInfo)){
//        }
//        aop_userService.printUser(aop_userInfo);
//        Aop_UserNameValidate  aop_userNameVaidate = (Aop_UserNameValidate) aop_userService;
//        aop_userNameVaidate.userNameValidate(aop_userInfo);
//



    }


    @Test
    public void getBean(){
        System.out.println(elBean.toString());
    }

    @Test
    public void xml(){
        bean_spring_other.use();
    }

    @Test
    public void value_Equels(){
        System.out.println(value_bean1==value_bean11);
        System.out.println(value_bean==value_beana);
    }

    @Test
    public void value_bean1(){

        System.out.println(value_bean1);
        System.out.println(value_bean1.getPassword());
    }

    @Test
    public void scan_controller(){

    }


    @Test
    public void Bean_jziyy(){
        jziYY.speak();
    }

    @Test
    public void persion(){
        persion.speak();
    }

    @Test
    public void Scan1(){
        System.out.println(bean_user);
    }

    @Test
    public void value(){
        System.out.println(value_bean);
    }

    @Test
    public void conditionalOnpropertyBean(){
        conditionalOnpropertyBean.speak();
    }


    @Test
    public void conditional (){
        conditionalBean.speek();
    }
    @Test
    public void configurationProperties(){
        System.out.println(configurationPropertiesBean);
    }
    @Test
    public void test(){
        System.out.println("aaaa");
        //lambok @Bean注解提供了重写equals功能
        System.out.println("--------equals");
        System.out.println(bean);
        System.out.println(bean1.equals(bean));
        //hashcode
        System.out.println("--------hashcode");
        System.out.println(bean1.hashCode());
        System.out.println(bean);
        System.out.println(bean.hashCode());
        System.out.println(bean2);
        System.out.println(bean2.hashCode());


    }

}
