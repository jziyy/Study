package com.example.demo.utils.interfacetesting;

import com.baidu.aip.util.Base64Util;
import com.example.demo.utils.FileUtil;

import java.io.File;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * OCR 通用识别
 * 食品经营许可证
 */
public class General_spjyxkz {


    public static void main(String[] args) {

        File file =new File("E:\\work\\下周任务\\新建文件夹");
        File [] files =file.listFiles();
        Arrays.stream(files).forEach(s ->getJson(s.getAbsolutePath()));


    }



    public static String getJson(String filePath) {

        String otherHost = "http://localhost:9090/znspxc_api/oil_distinguish/personDistinguish";
        //接收base64
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("baseimage", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");

            //String accessToken = AuthService.getAuth();
            //取得的json字符串
            String result = HttpUtil.post(otherHost, "", params).replaceAll("char","char1");

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
