package com.example.demo.annotation.mvc.controller;

import com.example.demo.annotation.mvc.bean.Mvc_bean;
import com.example.demo.com.proxy.proxy1.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(value = "/mvc",method = {RequestMethod.GET,RequestMethod.POST})
public class Mvc_Controller {

    @Autowired
    Mvc_bean mvc_bean;

    @RequestMapping(value = "/mvc_controller")
    public String getMessage(){
        mvc_bean.setName("jziyy");
        mvc_bean.setPassword("jziyy");

        return mvc_bean.toString();
    }

    @RequestMapping("/mvc_init")
    public String getinit(){
        return mvc_bean.toString();
    }
}
