package com.example.demo.com.lambda;

import java.util.HashMap;
import java.util.Map;

public class Demo_Foreach {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.forEach((k,v) -> {if (k.equals("oil_firesmalleg_size")){
            System.out.println(k);
        }if (k.equals("oil_firebigeg_size")){
            System.out.println(v);        }
        });
    }
}
