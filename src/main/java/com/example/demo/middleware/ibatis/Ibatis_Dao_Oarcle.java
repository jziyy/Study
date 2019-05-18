package com.example.demo.middleware.ibatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface Ibatis_Dao_Oarcle {

    @Select("select site_ent_id from aashop20192")
    List<String> getList();
}
