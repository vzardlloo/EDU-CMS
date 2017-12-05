package com.vzard.educms.util;


import com.vzard.educms.constant.CommonConstant;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SessionUtil {



    //获取保存在Session中的对象
    public static <T> T getSession(HttpServletRequest request,T t){
        return (T) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
    }

    //将对象保存在Session中
    public static <T> void setSession(HttpServletRequest request,T t){
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,t);
    }


    //解码
    public static String decode(String source,String enc){
        if (source == null || "".equals(source)){
            return "";
        }
        String ret = "";
        try {
            ret = URLDecoder.decode(source, enc);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return ret;
    }


    //编码
    public static String encode(String source,String enc){
        if (source == null || "".equals(source)){
            return "";
        }
        String ret = "";
        try {
            ret = URLEncoder.encode(source, enc);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return ret;
    }


}
