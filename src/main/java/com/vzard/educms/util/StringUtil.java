package com.vzard.educms.util;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    public static String toUpperCamelCase(String str) {
        return toCamelCase(str, true);
    }

    public static String toLowerCamelCase(String str) {
        return toCamelCase(str, false);
    }

    private static String toCamelCase(String str, boolean upper) {
        StringBuilder sb = new StringBuilder(str.length() * 2);

        boolean flag = upper;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '_':
                    flag = true;
                    break;
                default:
                    if (flag) {
                        flag = false;
                        sb.append(String.valueOf(str.charAt(i)).toUpperCase());
                    } else {
                        sb.append(str.charAt(i));
                    }
                    break;
            }
        }

        return sb.toString();
    }

    public static boolean isNumberString(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isIntegerString(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean equals(String str1, String str2) {
        return GenericUtil.equals(str1, str2);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String valueOrDefault(String value, String def) {
        if (isEmpty(value)) {
            return def;
        }

        return value;
    }

    public static String randomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }


    public static int compareVersionString(String version1, String version2) {
        if (StringUtil.isEmpty(version1))
            return -1;
        if (StringUtil.isEmpty(version2))
            return -1;

        List<Integer> version1SplitNumber = Arrays.stream(StringUtils.splitByWholeSeparator(version1.trim(), ".")).map(x -> {
            try {
                return Integer.parseInt(x);
            } catch (Exception ignore) {
                return 0;
            }
        }).collect(Collectors.toList());
        List<Integer> version2SplitNumber = Arrays.stream(StringUtils.splitByWholeSeparator(version2.trim(), ".")).map(x -> {
            try {
                return Integer.parseInt(x);
            } catch (Exception ignore) {
                return 0;
            }
        }).collect(Collectors.toList());

        int length = Math.min(version1SplitNumber.size(), version2SplitNumber.size());

        for (int i = 0; i < length; i++) {
            if (version1SplitNumber.get(i) > version2SplitNumber.get(i))
                return 1;
            else if (version1SplitNumber.get(i) < version2SplitNumber.get(i))
                return -1;
        }

        if (version1SplitNumber.size() > length)
            return 1;
        else if (version2SplitNumber.size() > length)
            return -1;

        return 0;
    }



}
