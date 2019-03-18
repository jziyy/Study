package aaaa.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GetUrlStr {


    /**
     * 转换字符转中的中文为url格式编码
     * @param string
     * @return
     */
    public static String changeChinaToURL(String string) {
        StringBuffer stringBuffer =new StringBuffer();

        try {
            char [] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 0x4E00 && chars[i] <= 0x9FA5){
                 stringBuffer.append(URLEncoder.encode(String.valueOf(chars[i]),"gb2312"));
                }
                else {
                    stringBuffer.append(String.valueOf(chars[i]));
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    return stringBuffer.toString();
    }


}
