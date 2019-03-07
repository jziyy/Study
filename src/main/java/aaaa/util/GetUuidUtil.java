package aaaa.util;

import java.util.UUID;

public class GetUuidUtil {
	/**
     * 获得一个UUID 
     * @return String UUID 
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号 
        return uuid.replaceAll("-", "");
    }
    public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
