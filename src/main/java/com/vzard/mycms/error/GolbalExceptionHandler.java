package com.vzard.mycms.error;

import io.swagger.annotations.ResponseHeader;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GolbalExceptionHandler {


    @ExceptionHandler(value = ErrorException.class)
    @ResponseBody
    public ErrorResponseModel golbalExceptionHander(ErrorException e, HttpServletRequest request){

        return ErrorResponseModel.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .url(request.getRequestURL().toString()).build();

    }

}
