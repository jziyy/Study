package com.example.demo.middleware.ibatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
@Slf4j
public class Ibatis_SQLFactory {
    public  static String insertIbatis_Bean(Ibatis_Bean bean){
        SQL sql = new SQL();
        sql.INSERT_INTO("userinfo");
        if (bean.getName()!=null){
            sql.VALUES("name","#{name}");
        }
        if (bean.getPassword()!=null){
            sql.VALUES("password","#{password}");
        }
        return sql.toString();
    }

    public static String insertManyIbatis_Bean(List<Ibatis_Bean> list){
        SQL sql = new SQL();
        sql.INSERT_INTO("userinfo");
        sql.INTO_COLUMNS("name","password");
        System.out.println(sql);
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append(sql.toString());
        stringBuffer.append("values");
        System.out.println(list);
        list.forEach(bean -> {
            stringBuffer.append("(");
            stringBuffer.append("'" + bean.getName() + "'");
            stringBuffer.append(",");
            stringBuffer.append("'" +bean.getPassword() + "'");
            stringBuffer.append(")");
            stringBuffer.append(",");
                }
        );
        System.out.println(stringBuffer.toString().substring(0,stringBuffer.length() -1));
        return stringBuffer.toString().substring(0,stringBuffer.length() -1);

        }

}
