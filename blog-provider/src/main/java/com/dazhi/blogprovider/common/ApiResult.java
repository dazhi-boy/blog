package com.dazhi.blogprovider.common;

import org.springframework.stereotype.Component;

@Component
public class ApiResult<T> {

    private ApiResultStatus status;
    private String message;
    private T data;

    public ApiResult(){}

    public ApiResult(ApiResultStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public <T> ApiResult<T> success(T data) {
        return new ApiResult<T>(ApiResultStatus.SUCCESS, "api.success", data);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}

enum ApiResultStatus {
    SUCCESS,FAILED,UNDEFINED;
}
