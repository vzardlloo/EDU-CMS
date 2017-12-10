package com.vzard.mycms.error;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseModel<T> {

    private int code;
    private String mesage;
    private T data;
    private String url;

}
