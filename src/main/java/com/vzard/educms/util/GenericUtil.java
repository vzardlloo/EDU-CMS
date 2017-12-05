package com.vzard.educms.util;


public class GenericUtil {
    public static <T> T valueOrDefault(T value, T def){
        if(value == null){
            return def;
        }
        return value;
    }

    public static <T> boolean equals(T str1, T str2){
        if(str1 != null){
            return str1.equals(str2);
        }

        return str2 == null;
    }




}
