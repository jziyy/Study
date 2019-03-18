package com.example.demo.annotation.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Slf4j
@Configuration
public class Config {


    @Value("aasdasda")
    String aaa;

    @Bean("userbean1")
    @Scope(value = "prototype")
    public UserBean getBean(){
        UserBean bean =new UserBean();
        bean.setName("aa");
        bean.setPassword("jziyy");
      //  log.info("aaaaaaaaaaaa" + bean.toString());
        return bean;
    }

    @Bean("userbean2")
    @Scope(value = "prototype")
    public UserBean getBean1(){
        UserBean bean =new UserBean();
        bean.setName("aaaaaaaaaa");
        bean.setPassword("jziyy111111");
        //log.info("aaaaaaaaa" + bean.toString());

        return bean;
    }


    @Bean
    public Bean_user bean_user(@Autowired@Qualifier("userbean2")UserBean user){
        return new Bean_user(user);
    }
}
