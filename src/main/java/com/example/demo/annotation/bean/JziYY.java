package com.example.demo.annotation.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
public class JziYY implements Persion{
    private Persion persion;
    JziYY(@Autowired@Qualifier("jz") Persion persion){
        this.persion = persion;
    }

    @Override
    public void speak() {
        persion.speak();
    }
}
