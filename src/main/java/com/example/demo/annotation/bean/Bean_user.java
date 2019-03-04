package com.example.demo.annotation.bean;

import lombok.Data;

@Data
public class Bean_user {
    private UserBean name;
    Bean_user(UserBean name){
        this.name =name;
    }

}
