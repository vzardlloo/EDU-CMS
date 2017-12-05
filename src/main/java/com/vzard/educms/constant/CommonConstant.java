package com.vzard.educms.constant;


public class CommonConstant {

    /**
     * 登录用户的session key
     */

    public static final String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "SH_SIGNIN_USER";

    public static final String JC_REFERRER_COOKIE = "JC_REFERRER_COOKIE";

    /**
     * AES盐值
     */
    public static String AES_SALT;


    /**
     * 用户对象放到Session中的键名称
     */
    public static final String USER_CONTEXT = "USER_CONTEXT";

    /**
     * 将登录前的URL放到Session中的键名称
     */
    public static final String LOGIN_TO_URL = "toUrl";

    /**
     * 每页的记录数
     */
    public static final int PAGE_SIZE = 3;



}
