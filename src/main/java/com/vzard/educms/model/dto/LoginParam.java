package com.vzard.educms.model.dto;

/**
 * 登录参数
 */
public class LoginParam {

    private String number;

    private String password;


    public LoginParam() {
    }

    public LoginParam(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
