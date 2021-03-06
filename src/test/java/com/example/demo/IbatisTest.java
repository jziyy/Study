package com.example.demo;


import com.example.demo.annotation.SpringUtil;
import com.example.demo.middleware.ibatis.Ibatis_Bean;
import com.example.demo.middleware.ibatis.Ibatis_Dao;
import com.example.demo.middleware.ibatis.Ibatis_Dao_Oarcle;
import com.example.demo.middleware.ibatis.service.StudyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Import(SpringUtil.class)
public class IbatisTest extends DemoApplicationTests {
    @Autowired
    StudyService studyService;

    @Autowired
    Ibatis_Dao ibatis_dao;

    @Autowired
    Ibatis_Dao_Oarcle ibatis_dao_oarcle;

    @Test
    public void demo1(){
        System.out.println(ibatis_dao_oarcle.getList());
    }

    @Test
    public void InsertManyBean(){
        List<Ibatis_Bean> ibatis_beanList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Ibatis_Bean ibatis_bean = new Ibatis_Bean();
            ibatis_bean.setName("nameA" + i);
            ibatis_bean.setPassword("passwordA" + i);
            ibatis_beanList.add(ibatis_bean);
            System.out.println(ibatis_beanList);
        }
        System.out.println("-------" + ibatis_beanList);
        ibatis_dao.insertManyBean(ibatis_beanList);
    }

    @Test
    public void datasouse(){

        DataSource dataSource = SpringUtil.getBean(DataSource.class) ;
        System.out.println(dataSource.getClass().getName());


    }

    @Test
    public void ibatisTranscational(){
        Ibatis_Bean ibatis_bean = new Ibatis_Bean();
        ibatis_bean.setId(111111);
        ibatis_bean.setName("jziyy");
        ibatis_bean.setPassword("jziyy");
        System.out.println(studyService.selectAndPrint());
    }


}
