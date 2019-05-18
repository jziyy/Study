package com.example.demo.middleware.ibatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Ibatis_StudyDao {
    @Select("select * from userinfo")
    List<Ibatis_Bean> selectAll();

    @Insert("insert into userinfo(name,password) values(#{ibatis_bean.name},#{ibatis_bean.password})")
    void insert(@Param("ibatis_bean") Ibatis_Bean ibatis_bean);
}
