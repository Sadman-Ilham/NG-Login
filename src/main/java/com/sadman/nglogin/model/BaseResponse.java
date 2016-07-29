package com.sadman.nglogin.model;

/**
 * @author Sadman
 * @since Jul 28, 2016
 */
public class BaseResponse {
    private int responseCode;
    private String responseMessage;

    public BaseResponse(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
