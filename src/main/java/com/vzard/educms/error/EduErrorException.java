package com.vzard.educms.error;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/12
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

public class EduErrorException extends RuntimeException{

    private Integer code;

    public EduErrorException(String msg,Integer code){

        super(msg);
        this.code = code;
    }


    public Integer getCode(){
        return code;
    }


    public void setCode(Integer code){

        this.code = code;

    }


}
