package com.example.demo.annotation.aop.service;

import com.example.demo.annotation.aop.bean.Aop_UserInfo;
import org.springframework.stereotype.Service;

@Service
public class Aop_UserServiceImpl implements Aop_UserService {

    @Override
    public void printUser(Aop_UserInfo userInfo) {
        if (userInfo==null){
            throw new RuntimeException("传递参数为空");
        }else {
            System.out.println(userInfo);
        }
    }
}
