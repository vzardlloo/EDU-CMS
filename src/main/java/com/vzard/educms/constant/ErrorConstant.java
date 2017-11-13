package com.vzard.educms.constant;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/12
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

public class ErrorConstant {

    //错误码
    public static final int ERROR_CODE_USER_NOT_FOUND = 10001;
    public static final int ERROR_CODE_USER_INFO_NOT_NULL = 10002;
    public static final int ERROR_CODE_LOGIN_ERROR = 10003;
    public static final int ERROR_CODE_USER_NOT_MATCH = 10004;
    public static final int ERROR_CODE_NOTIFICATION_NOT_FOUND = 10005;
    public static final int ERROR_CODE_EVENT_NOT_FOUND = 10006;
    public static final int ERROR_CODE_COMMENT_NOT_FOUND = 10007;
    public static final int ERROR_CODE_FRIEND_IS_FOLLOW = 10008;
    public static final int ERROR_CODE_FRIEND_NOT_FOLLOW = 10009;
    public static final int ERROR_CODE_ERROR_OPTION = 10010;
    public static final int ERROR_CODE_FILE_NOT_NULL = 10011;
    public static final int ERROR_CODE_FILE_NOT_MATCH = 10012;
    public static final int ERROR_CODE_FILE_UPLOAD_ERROR = 10013;
    public static final int ERROR_CODE_FILE_SIZE_ERROR = 10014;
    public static final int ERROR_CODE_SERVER_ERROR = 10015;
    public static final int ERROR_CODE_TOKEN_ERROR = 10016;
    public static final int ERROR_CODE_USER_EXIST_ERROR = 10017;
    public static final int ERROR_CODE_USER_PASSWORD_SHORT_ERROR = 10018;
    public static final int ERROR_CODE_NUMBER_FORMAT_ERROR = 10019;
    public static final int ERROR_CODE_COMMENT_EVENT_ERROR = 10020;
    public static final int ERROR_CODE_ARGUMENT_NOT_NULL = 10021;
    public static final int ERROR_CODE_POST_NOT_FOUND = 10022;
    public static final int ERROR_CODE_USER_NAME_NOT_NULL = 10023;
    //错误消息
    public static final String ERROR_MSG_USER_NOT_FOUND = "找不到此用户.";
    public static final String ERROR_MSG_USER_INFO_NOT_NULL = "用户信息不能为空.";
    public static final String ERROR_MSG_LOGIN_ERROR = "登录失败,请检查账号密码.";
    public static final String ERROR_MSG_USER_NOT_MATCH = "用户信息不匹配.";
    public static final String ERROR_MSG_NOTIFICATION_NOT_FOUND = "该消息提醒不存在.";
    public static final String ERROR_MSG_EVENT_NOT_FOUND = "找不到此事件.";
    public static final String ERROR_MSG_COMMENT_NOT_FOUND = "找不到此评论.";
    public static final String ERROR_MSG_FRIEND_IS_FOLLOW = "已关注此用户.";
    public static final String ERROR_MSG_FRIEND_NOT_FOLLOW = "未关注此用户.";
    public static final String ERROR_MSG_ERROR_OPTION = "此操作不允许.";
    public static final String ERROR_MSG_FILE_NOT_NULL = "文件不能为空.";
    public static final String ERROR_MSG_FILE_NOT_MATCH = "文件类型不匹配(只支持jpg,png,jpeg).";
    public static final String ERROR_MSG_NUMBER_FORMAT_EXCEPTION = "参数类型不匹配请检查后重试";
    public static final String ERROR_MSG_COMMENT_EVENT_ERROR = "评论事件不一致,不能发表回复";
    public static final String ERROR_MSG_ARGUMENT_NOT_NULL = "参数不能给为空";
    public static final String ERROR_MSG_POST_NOT_FOUND = "找不到此动态";

    //连接超时
    public static final String ERROR_MSG_FILE_UPLOAD_ERROR = "文件上传失败(请检查网络连接后重试).";
    public static final String ERROR_MSG_FILE_SIZE_ERROR = "单个文件大小不能超过2MB(多个文件总大小不能超过20MB).";
    public static final String ERROR_MSG_SERVER_ERROR = "服务出错.";
    public static final String ERROR_MSG_TOKEN_ERROR = "验证失败,请重新登录后执行此操作.";
    public static final String ERROR_MSG_USER_EXIST_ERROR = "该用户已存在.";
    public static final String ERROR_MSG_USER_PASSWORD_SHORT_ERROR = "用户密码长度不能小于8位";
    public static final String ERROR_MSG_USER_NAME_NOT_NULL = "用户名不能为空";


}
