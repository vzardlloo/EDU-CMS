package com.vzard.educms.error;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/12
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

@Getter
@Setter
@Builder
public class ErrorResponseModel<T> {

    private int code;
    private String message;
    private T data;
    private String url;

    @Override
    public String toString(){


        return "ErrorResponseModel{\n"
                +"code: "+code+",\n"
                +"message: "+message+",\n"
                +"url: "+url+",\n"
                +'}';



    }










}
