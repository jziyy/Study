package com.example.demo.annotation.aop.service;

import com.example.demo.annotation.aop.bean.Aop_UserInfo;
import org.springframework.util.StringUtils;

public class Aop_UserValidateImpl implements Aop_UserValidate {

    public boolean validate(Aop_UserInfo userInfo) {
        System.out.println("引入接口" + this.getClass().getSimpleName());
        if (StringUtils.isEmpty(userInfo.getPassword()) || StringUtils.isEmpty(userInfo.getUsername())){
            return false;
        }

        return true;
    }
}
