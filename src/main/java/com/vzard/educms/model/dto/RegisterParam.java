package com.vzard.educms.model.dto;


public class RegisterParam {

    private String number;

    private String name;

    private String password;

    private String brithday;

    private String gender;

    private String address;

    private String phoneNum;

    public RegisterParam() {
    }

    public RegisterParam(String number, String name, String password, String brithday, String gender, String address, String phoneNum) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.brithday = brithday;
        this.gender = gender;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}


