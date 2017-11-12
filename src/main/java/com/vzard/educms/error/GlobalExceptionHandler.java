package com.vzard.educms.error;

import com.vzard.educms.constant.ErrorConstant;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/12
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 * Description: 全局错误拦截
 **/


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EduErrorException.class)
    @ResponseBody
    public ErrorResponseModel jsonErrorHandler(EduErrorException e, HttpServletRequest request){

        return ErrorResponseModel.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .url(request.getRequestURL().toString()).build();
    }


    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseBody
    public ErrorResponseModel jsonErrorHandler(NumberFormatException e,HttpServletRequest request){


        return ErrorResponseModel.builder()
                .code(ErrorConstant.ERROR_CODE_NUMBER_FORMAT_ERROR)
                .message(ErrorConstant.ERROR_MSG_NUMBER_FORMAT_EXCEPTION)
                .url(request.getRequestURL().toString()).build();

    }









}
