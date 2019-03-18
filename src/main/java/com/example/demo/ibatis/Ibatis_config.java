package com.example.demo.ibatis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
public class Ibatis_config {
    @Autowired
    private Ibatis_Dao ibatis_dao;

    @Transactional
    public void insert(List<Ibatis_Bean> list){
        ibatis_dao.insertManyBean(list);
    }


}
