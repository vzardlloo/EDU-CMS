package com.vzard.mycms.error;


public class ErrorException extends RuntimeException {

    private Integer code;
    public ErrorException(String msg){}
    public ErrorException(String msg,Integer code){
        super(msg);
        this.code=code;

    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }

}
