package com.example.demo.annotation.componentScan.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class Scan_Controller {

    private String name;
    private String password;

    public void setName(String name) {
      log.info("该对象已经实例化");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
