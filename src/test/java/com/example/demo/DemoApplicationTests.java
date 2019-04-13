package com.example.demo;

import com.DemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class DemoApplicationTests {

    @Before
    public void before(){
        System.out.println("----------------------before");
    }
    @After
    public void after(){
        System.out.println("-----------------------after");
    }


}

