package com.example.demo.com.lambda.stream;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class Stream_2 {
    public static void main(String[] args)  {
        Map<String,Object> map = new HashMap<>();
        map.put("res_code","1");
        map.put("res_msg","成功");
        Data1 data1 = new Data1();
        data1.act_code = 7;
        data1.irregular = 1;
        data1.other = 1;
        data1.specification = 1;
        map.put("data",data1);
        System.out.println(JSON.toJSONString(map));
    }
    @Data
    public static class Data1{
        private Integer act_code;
        private Integer other;
        private Integer irregular;
        private Integer specification;
    }
}
