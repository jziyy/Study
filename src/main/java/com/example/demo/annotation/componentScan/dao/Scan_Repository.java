package com.example.demo.annotation.componentScan.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Scan_Repository {
    private String name;
    private String password;
}
