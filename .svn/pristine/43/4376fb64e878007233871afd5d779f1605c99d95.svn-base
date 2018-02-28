package com.cxs.framework.utils;

import java.io.UnsupportedEncodingException;  
  
import sun.misc.*;

/**
 *
 * @Description: base64工具类
 * @ClassName: Base64
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年08月17日
 */
public class Base64 {  
    // 加密  
    public static String getBase64(String str) {  
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }  
        return s;  
    }  
  
    // 解密  
    public static String getFromBase64(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }

    public static void main(String [] args){

        String gbhApiUAP = "SHANGHAIFENG :IKONIC2017";
        System.out.println(getBase64(gbhApiUAP));
        System.out.println("U0hBTkdIQUlGRU5HIDpJS09OSUMyMDE3".equals(getBase64(gbhApiUAP)));
        System.out.println(getFromBase64("U0hBTkdIQUlGRU5HIDpJS09OSUMyMDE3"));
    }
}  
