package com.example.demo.annotation.aop.service;

import com.example.demo.annotation.aop.bean.Aop_UserInfo;

public class Aop_UserNameVaidateImpl implements Aop_UserNameValidate {

    @Override
    public void userNameValidate(Aop_UserInfo aop_userInfo) {
        System.out.println(aop_userInfo.getUsername() + this.getClass().getSimpleName());
    }
}
