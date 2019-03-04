package com.example.demo.annotation.componentScan.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class Scan_Service {
    @Value("aaa")
    private String name;
    @Value("aaa")
    private String password;


}
