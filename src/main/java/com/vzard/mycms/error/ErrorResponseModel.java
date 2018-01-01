package com.vzard.mycms.error;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseModel<T> {

    private int httpStatus;
    private String message;
    private T data;
    private String url;

}
