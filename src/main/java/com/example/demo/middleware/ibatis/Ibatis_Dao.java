package com.example.demo.middleware.ibatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface Ibatis_Dao {
    @InsertProvider(type = Ibatis_SQLFactory.class ,method = "insertManyIbatis_Bean")
    void insertManyBean(List<Ibatis_Bean> list);

    @InsertProvider(type = Ibatis_SQLFactory.class,method = "insertIbatis_Bean")
    void insertOneBean(Ibatis_Bean bean);
}
