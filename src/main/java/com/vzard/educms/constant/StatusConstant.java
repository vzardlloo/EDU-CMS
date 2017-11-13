package com.vzard.educms.constant;



/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

public class StatusConstant {

    public static final int STATUS_CODE_SUCCESS = 200;
    public static final int STATUS_CODE_CREATE = 201;
    public static final int STATUS_CODE_ACCEPTED = 202;
    public static final int STATUS_CODE_BAD_REQUEST = 400;
    public static final int STATUS_CODE_UNAUTHORIZED = 401;
    public static final int STATUS_CODE_FORBIDDEN = 403;
    public static final int STATUS_CODE_NOT_FOUND = 404;
    public static final int STATUS_CODE_SERVER_ERROR = 500;

    public static final String STATUS_INFO_SUCCESS = "请求成功";
    public static final String STATUS_INFO_CREATED = "创建成功";
    public static final String STATUS_INFO_ACCEPTED = "更新成功";
    public static final String STATUS_INFO_BAD_REQUEST = "请求不存在";
    public static final String STATUS_INFO_UNAUTHORIZED = "未授权";
    public static final String STATUS_INFO_FORBIDDEN = "禁止访问";
    public static final String STATUS_INFO_NOT_FOUND = "资源不存在";
    public static final String STATUS_INFO_SERVER_ERROR = "服务器内部错误";


}
