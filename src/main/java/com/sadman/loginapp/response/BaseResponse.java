package com.sadman.loginapp.response;

/**
 * @author Sadman
 * @since Jul 28, 2016
 */
public class BaseResponse {
    int responseCode;

    public BaseResponse(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
