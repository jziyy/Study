package com.example.demo.ibatis.service;

import com.example.demo.ibatis.Ibatis_Bean;
import com.example.demo.ibatis.Ibatis_StudyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudyService {
    @Autowired
    Ibatis_StudyDao studyDao;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Ibatis_Bean> insertAndSelect(Ibatis_Bean ibatis_bean) {
        studyDao.insert(ibatis_bean);
        return studyDao.selectAll();
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Ibatis_Bean> selectAndPrint() {
        Ibatis_Bean ibatis_bean = new Ibatis_Bean();
        ibatis_bean.setName("jziyy0422");
        ibatis_bean.setPassword("jziyy0422");
        List<Ibatis_Bean> list = insertAndSelect(ibatis_bean);
        list.parallelStream().forEach(System.out::println);
        return list;

    }


}

